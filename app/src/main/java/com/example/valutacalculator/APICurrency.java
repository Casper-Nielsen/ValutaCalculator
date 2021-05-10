package com.example.valutacalculator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * This class gets the rates from a remote api
 *
 *@author CKN
 *@version 1.3
 *@since 1.3
 */
public class APICurrency implements CurrencyDAO<Valuta> {
    private static Valuta valuta;
    private Object lock = new Object();
    private Thread thread;

    public APICurrency(){
        // creates a thread to handel the api call
        thread = new Thread(new Runnable() {
            public void run() {
                getFromApi();
            }
        });
        thread.start();
    }

    /**
     * Method that gets the rates from a api
     *
     *@version 1.3
     *@since 1.3
     */
    @Override
    public Valuta getRates() {
        synchronized (lock){
            while (valuta == null){
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            return valuta;
        }
    }

    /**
     * Method that gets the rates from a api
     *
     *@version 1.3
     *@since 1.3
     */
    private void getFromApi() {
        try {
            String key = "5f95c5b52dab7f06848e678041a702b4"; // Insert key here
            String urlString = "http://data.fixer.io/api/latest?access_key=" + key;
            URL url = new URL(urlString);

            // Connecting to the api
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Getting the response code
            int responseCode = conn.getResponseCode();
            // Checking the response code
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                // Writes all the response data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                // Closes the scanner
                scanner.close();

                // Using parses the string to a json object
                JSONObject data_obj = new JSONObject(inline);
                // Creates a valuta object
                synchronized (lock){
                    valuta = new Valuta(data_obj);
                    // Notifies all waiting threads
                    lock.notifyAll();
                }
            }
        }
        catch (IOException e) {
                e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
