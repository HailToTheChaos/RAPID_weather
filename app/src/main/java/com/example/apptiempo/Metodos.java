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

    /**
     * Método que capitaliza un String
     * @param in (entrada)
     * @return String capitalizado
     */
    public static String capitalize(String in) {
        String aux = in.toUpperCase();
        return aux.charAt(0) + in.substring(1).toLowerCase();
    }
}





