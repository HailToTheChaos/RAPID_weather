package com.example.apptiempo;


import org.json.JSONException;
import org.json.JSONObject;


public class Metodos {

    public static String getURL(JSONObject jsonobj) {

        String enlace = "";

        try {
            enlace = jsonobj.getString("datos");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return enlace;
    }

    public static String capitalize(String in){
        String a= in.toUpperCase();
        return a.charAt(0)+in.substring(1);
}


}





