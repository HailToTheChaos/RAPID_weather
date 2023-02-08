package Modelos_clases;

import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModeloReporteHorario {

    private String nombre_municipio;
    private String estadoCielo;
    private float precipitacion; //en litro/m2
    private float probabilidadPrecipitacion;
    private float temperatura;
    private float sensacionTermica;
    private float humedadRel;
    private String viento;
    private int hora;

    public ModeloReporteHorario(JSONArray jsonArray) {
        try {
            //NOMBRE MUNICIPIO
            this.nombre_municipio = jsonArray.getJSONObject(0).getString("nombre");

            //ESTADO CIELO
            if(this.hora >= 7) {
                this.estadoCielo = jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("estadoCielo")
                        .getJSONObject(hora-7).getString("descripcion");
            }else{
                this.estadoCielo = jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("estadoCielo")
                        .getJSONObject(0).getString("descripcion");
            }
            //PRECIPITACIÓN
            if(this.hora >= 7) {
                this.precipitacion = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("precipitacion")
                        .getJSONObject(hora - 7).getString("value"));
            }else{
                this.precipitacion = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("precipitacion")
                        .getJSONObject(0).getString("value"));
            }

            //CONSULTAR ESTO CON JIMMY, NO PUEDO DARLE UNA PROB DE LLUVIA CONCRETA
            this.probabilidadPrecipitacion = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                    .getJSONArray("dia").getJSONObject(0).getJSONArray("probPrecipitacion")
                    .getJSONObject(0).getString("value"));

            //TEMPERATURA
            if(this.hora >=8) {
                this.temperatura = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("temperatura")
                        .getJSONObject(hora - 8).getString("value"));
            }else{
                this.temperatura = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("temperatura")
                        .getJSONObject(0).getString("value"));
            }

            //SENSACIÓN TÉRMICA
            if(this.hora >= 8){
                this.sensacionTermica = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("sensTermica")
                        .getJSONObject(hora-8).getString("value"));
            }else{
                this.sensacionTermica = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("sensTermica")
                        .getJSONObject(0).getString("value"));
            }

            //HUMEDAD RELATIVA
            if(this.hora >=8){
                this.humedadRel = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("sensTermica")
                        .getJSONObject(hora-8).getString("value"));
            }else{
                this.humedadRel = Float.parseFloat(jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("sensTermica")
                        .getJSONObject(0).getString("value"));
            }

            //HABLAR CON JIMMY
            /*if(this.hora >=8){
                this.viento = jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("vientoAndRachaMax")
                        .getJSONObject(hora-8).getString("value");
            }else{
                this.viento = jsonArray.getJSONObject(0).getJSONObject("prediccion")
                        .getJSONArray("dia").getJSONObject(0).getJSONArray("vientoAndRachaMax")
                        .getJSONObject(0).getString("value");
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public float getProbabilidadPrecipitacion() {
        return probabilidadPrecipitacion;
    }

    public void setProbabilidadPrecipitacion(float probabilidadPrecipitacion) {
        this.probabilidadPrecipitacion = probabilidadPrecipitacion;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public String getViento() {
        return viento;
    }

    public void setViento(String viento) {
        this.viento = viento;
    }

    public float getHumedadRel() {
        return humedadRel;
    }

    public void setHumedadRel(float humedadRel) {
        this.humedadRel = humedadRel;
    }

    public float getSensacionTermica() {
        return sensacionTermica;
    }

    public void setSensacionTermica(float sensacionTermica) {
        this.sensacionTermica = sensacionTermica;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }

    public void setEstadoCielo(String estadoCielo) {
        this.estadoCielo = estadoCielo;
    }

    public float getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(float precipitacion) {
        this.precipitacion = precipitacion;
    }

    public String toString() {
        DateTimeFormatter dtf = null;
        String fecha_reporte="";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            fecha_reporte = dtf.format(LocalDateTime.now());
        }

        return "Predicción horaria de "+this.nombre_municipio+"\n"+
                "Fecha del reporte: "+fecha_reporte+"\n"+
                "Temperatura: "+temperatura+"ºC"+"\n"+
                "Precipitaciones: "+precipitacion+" l/hora"+"\n"+
                "Probabilidad de Precipitación: "+probabilidadPrecipitacion+"ºC"+"\n"+
                "Estado del cielo: "+estadoCielo+"\n"+
                "Sensación térmica: "+sensacionTermica+"ºC"+"\n"+
                "Viento: "+viento+" km/h";
}
}
