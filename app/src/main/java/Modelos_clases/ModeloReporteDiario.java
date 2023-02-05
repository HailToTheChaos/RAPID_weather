package Modelos_clases;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class ModeloReporteDiario {
    private String nombre_municipio;
    private String temp_max;
    private String temp_min;
    private int probPrec;
    private String estadoCielo;
    private String viento;
    private String sensacionTermica;
    private int UV;
    private String fecha;



    public ModeloReporteDiario() {

    }

    public ModeloReporteDiario(JSONObject jsonarrDiario){

        try {

            this.nombre_municipio = jobj.getString("nombre");

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

    @NonNull
    @Override
    public String toString() {
        return "Predicción de " + this.nombre_municipio + "\n" +
                "Temperatura por horas: \n" +
                "Temperatura máxima: " + this.temp_max + "ºC" + "\n" +
                "Temperatura mínima: " + this.temp_min + "ºC" + "\n" +
                "Fecha del reporte: " + this.fecha;
    }

}
