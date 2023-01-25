package com.example.apptiempo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;

public class ModeloReporte {
    private String nombre_municipio;
    private String nombre_provincia;
    private String temp_max;
    private String temp_min;
    private String temp_actual;
    private String fecha;
    private String tiempo6;
    private String tiempo12;
    private String tiempo18;
    private String tiempo24;


    public ModeloReporte() {

    }

    public ModeloReporte(JSONArray jsonarr){
        JSONObject jobj;
        try {
            jobj = jsonarr.getJSONObject(0);

            this.nombre_municipio = jobj.getString("nombre");

            nombre_provincia = jobj.getString("provincia");

            this.tiempo6 = jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0)
                    .getJSONObject("temperatura").getJSONArray("dato").getJSONObject(0).getString("value");

            this.tiempo12 = jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0)
                    .getJSONObject("temperatura").getJSONArray("dato").getJSONObject(1).getString("value");

            this.tiempo18 = jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0)
                    .getJSONObject("temperatura").getJSONArray("dato").getJSONObject(2).getString("value");

            this.tiempo24 = jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0)
                    .getJSONObject("temperatura").getJSONArray("dato").getJSONObject(3).getString("value");

            this.temp_max = (jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0).
                    getJSONObject("temperatura").getString("maxima"));

            this.temp_min = jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0).
                    getJSONObject("temperatura").getString("minima");

            this.fecha = jobj.getString("elaborado");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTiempo6() {
        return tiempo6;
    }

    public void setTiempo6(String tiempo6) {
        this.tiempo6 = tiempo6;
    }

    public String getTiempo12() {
        return tiempo12;
    }

    public void setTiempo12(String tiempo12) {
        this.tiempo12 = tiempo12;
    }

    public String getTiempo18() {
        return tiempo18;
    }

    public void setTiempo18(String tiempo18) {
        this.tiempo18 = tiempo18;
    }

    public String getTiempo24() {
        return tiempo24;
    }

    public void setTiempo24(String tiempo24) {
        this.tiempo24 = tiempo24;
    }

    public String getTemp_actual() {
        return temp_actual;
    }

    public void setTemp_actual(String temp_actual) {
        this.temp_actual = temp_actual;
    }

    //Metodos

    //Por implementar
//    public String mostrarTiempoActual() throws JSONException {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            LocalDateTime ahora= LocalDateTime.now();
//            int hora = ahora.getHour();
//
//            if(hora<=11){
//
//            } else if(hora>=12 &&)
//        }
//        JSONArray jsonArr = new JSONArray(this.temp_actual);
//
//        for (int i = 0; i < jsonArr.length() ; i++) {
//            if (jsonArr.getJSONObject(i).getString("hora").equalsIgnoreCase(municipio_nombre)) {
//                return jsonArr.getJSONObject(i).getString("municipio_id");
//
//            }
//        }
//        return "";
//    }

    public String toString() {
        return "Predicción de " + this.nombre_municipio + "\n" +
                "Nombre de la provincia: " + this.nombre_provincia + "\n" +
                "Temperatura por horas: \n" +
                "-Temperatura a las 6:00: " + this.tiempo6 + "ºC" + "\n" +
                "-Temperatura a las 12:00: " + this.tiempo12 + "ºC" + "\n" +
                "-Temperatura a las 18:00: " + this.tiempo18 + "ºC" + "\n" +
                "-Temperatura a las 24:00: " + this.tiempo24 + "ºC" + "\n" +
                "Temperatura máxima: " + this.temp_max + "ºC" + "\n" +
                "Temperatura mínima: " + this.temp_min + "ºC" + "\n" +
                "Fecha del reporte: " + this.fecha;
    }

}
