package com.example.valutacalculator;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.*;

import org.json.JSONException;
import org.json.JSONObject;

public class APICurrency implements CurrencyDAO<Valuta> {
    private static Valuta valuta;
    JsonObjectRequest request;
    private Object lock = new Object();

    public APICurrency(){
        getFromApi();
    }
    @Override
    public Valuta getRates() {
            return valuta;
    }

    private void getFromApi(){
            String url = "http://data.fixer.io/api/latest?access_key=5f95c5b52dab7f06848e678041a702b4" ;
        request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            valuta = new Valuta(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
    }


}
