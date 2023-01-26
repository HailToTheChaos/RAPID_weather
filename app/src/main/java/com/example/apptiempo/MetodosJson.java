package com.example.apptiempo;


import org.json.JSONException;
import org.json.JSONObject;


public class MetodosJson {


    private static ModeloReporte mr = new ModeloReporte();



    public static String getURL(JSONObject jsonobj) {

        String enlace = "";

        try {
            enlace = jsonobj.getString("datos");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return enlace;
    }




}





