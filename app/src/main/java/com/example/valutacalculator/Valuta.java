package com.example.valutacalculator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class is a model to hold all the Valuta-rates
 *
 *@author CKN
 *@version 1.0
 *@since 1.0
 */
public class Valuta {
    public boolean success;
    public Timestamp timestamp;
    public String base;
    public Date date;
    public Map<String, Integer> rates;

    /**
     * empty Constructor
     *
     *@version 1.0
     *@since 1.0
     */
    public Valuta(){

    }

    /**
     * Constructor that converts from json object
     *
     *@version 1.0
     *@since 1.0
     *@param json the json object to convert
     */
    public Valuta(JSONObject json) throws JSONException {
        rates = new HashMap<String, Integer>();
        success = json.getBoolean("success");
        timestamp = new Timestamp(json.getLong("timestamp"));

        // Converts list to a map
        JSONObject jsonList = json.getJSONObject("rates");
        Iterator<String> temp = jsonList.keys();
        while(temp.hasNext()){
            String name = temp.next();
            rates.put(name , jsonList.getInt(name));
        }
    }
}
