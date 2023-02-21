package com.example.apptiempo;


import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

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

    public static void mostrarAlerta(String mensaje, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensaje).setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();//con esto se sale
            }
        }).create().show();
    }
}





