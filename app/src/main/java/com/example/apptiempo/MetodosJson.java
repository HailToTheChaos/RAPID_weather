package com.example.apptiempo;

import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MetodosJson {

    private static ModeloReporte mr = new ModeloReporte();

    public static String getIDMunicipio(String municipio_nombre, BufferedReader br) {

        String IDmunicipio = "";

        try {
            JsonParser parser = new JsonParser();

            Object obj = parser.parse(br);
            JSONArray array = null;
            try {
                array = new JSONArray(obj.toString());
                br.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < array.length(); i++) {
                try {
                    if (array.getJSONObject(i).getString("nombre").equalsIgnoreCase(municipio_nombre)) {
                        IDmunicipio = array.getJSONObject(i).getString("municipio_id");

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (ClassCastException | NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return IDmunicipio;
    }

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





