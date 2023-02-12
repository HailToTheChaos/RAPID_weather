package Modelos_clases;

import android.os.Build;

import androidx.annotation.NonNull;

import org.json.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class ModeloReporteDiario {
    private String temp_max;
    private String temp_min;
    private String probPrec;
    private String estadoCielo;
    private String viento;
    private String sensacionTermicaMax;
    private String sensacionTermicaMin;
    private String fecha;


    public ModeloReporteDiario() {

    }

    public ModeloReporteDiario(JSONObject jsonObjDiario) {

        try {
            //Paar parsear y formatear la fecha
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formato = new SimpleDateFormat("E, dd MMM");


            //TEMP MAX
            this.temp_max = jsonObjDiario.getJSONObject("temperatura").getString("maxima") + "º C";

            //TEMP MIN
            this.temp_min = jsonObjDiario.getJSONObject("temperatura").getString("minima") + "º C";


            //PROB PRECIPITACION
            this.probPrec = jsonObjDiario.getJSONArray("probPrecipitacion").getJSONObject(0).getString("value") + " %";

            //Revisar
            JSONArray estadoAux = jsonObjDiario.getJSONArray("estadoCielo");
            for (int i = 0; i < estadoAux.length(); i++) {
                if (!estadoAux.getJSONObject(i).getString("descripcion").equals("")) {
                    this.estadoCielo = estadoAux.getJSONObject(i).getString("descripcion");
                }
            }


            //VIENTO

            this.viento = jsonObjDiario.getJSONArray("viento").getJSONObject(0).getString("velocidad");

            //SENSACION TÉRMICA MAX
            this.sensacionTermicaMax = jsonObjDiario.getJSONObject("sensTermica").getString("maxima") + "º C";

            //SENSACION TÉRMICA MIN
            this.sensacionTermicaMin = jsonObjDiario.getJSONObject("sensTermica").getString("minima") + "º C";


            //FECHA
            try {

                Date fechaParse = parser.parse(jsonObjDiario.getString("fecha").substring(0, 10));
                this.fecha = formato.format(fechaParse);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
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


    @NonNull
    @Override
    public String toString() {
        DateTimeFormatter dtf = null;
        String fecha_reporte = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            fecha_reporte = dtf.format(LocalDateTime.now());
        }

        return fecha + "\n\nMAX: " + this.temp_max +
                " MIN: " + this.temp_min + "\n" +
                "Probabilidad de Precipitacion: " + this.probPrec + "\n" +
                "Estado del cielo: " + this.estadoCielo + "\n" +
                "Viento: " + this.viento + " km/h" + "\n" +
                "Sensación térmica: " + this.sensacionTermicaMax + " " + this.sensacionTermicaMin + "\n\n";
    }

}
