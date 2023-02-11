package Modelos_clases;

import android.os.Build;

import androidx.annotation.NonNull;

import org.json.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ModeloReporteDiario {
    private String temp_max;
    private String temp_min;
    private String probPrec;
    private String estadoCielo;
    private String viento;
    private String sensacionTermicaMax;
    private String sensacionTermicaMin;
    private String UV;
    private String fecha;
    private static LocalDateTime locaDate;
    private int hora;




    public ModeloReporteDiario() {

    }

    public ModeloReporteDiario(JSONObject jsonObjDiario){

        try {
            //HORA
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                locaDate = LocalDateTime.now();
                this.hora = locaDate.getHour();
            }

            //TEMP MAX
            this.temp_max = jsonObjDiario.getJSONObject("temperatura").getString("maxima")+"º";

            /*(jobj.getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0).
                    getJSONObject("temperatura").getString("maxima"));*/

            //TEMP MIN
            this.temp_min = jsonObjDiario.getJSONObject("temperatura").getString("minima")+"º";


            //PROB PRECIPITACION
            this.probPrec = jsonObjDiario.getJSONArray("probPrecipitacion").getJSONObject(0).getString("value")+" %";

            //Revisar
            JSONArray estadoAux = jsonObjDiario.getJSONArray("estadoCielo");
            for (int i = 0; i < estadoAux.length(); i++) {
                if(!estadoAux.getJSONObject(i).getString("descripcion").equals("")){
                    this.estadoCielo = estadoAux.getJSONObject(i).getString("descripcion");
                }
            }


            //VIENTO

                this.viento = jsonObjDiario.getJSONArray("viento").getJSONObject(0).getString("velocidad");

            //SENSACION TÉRMICA MAX
            this.sensacionTermicaMax = jsonObjDiario.getJSONObject("sensTermica").getString("maxima");

            //SENSACION TÉRMICA MIN
            this.sensacionTermicaMin = jsonObjDiario.getJSONObject("sensTermica").getString("minima");

            //UV
//            this.UV = Integer.parseInt(jsonObjDiario.getString("uvMax"));

            //FECHA
            this.fecha = jsonObjDiario.getString("fecha");
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
        DateTimeFormatter dtf = null;
        String fecha_reporte="";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            fecha_reporte = dtf.format(LocalDateTime.now());
        }

        return  "Temperatura por horas: \n" +
                "Temperatura máxima: " + this.temp_max + "ºC" + "\n" +
                "Temperatura mínima: " + this.temp_min + "ºC" + "\n" +
                "Fecha del reporte: " + fecha_reporte +"\n"+
                "Probabilidad de Precipitación: "+ this.probPrec+" %"+"\n"+
                "Estado del cielo: "+this.estadoCielo+"\n"+
                "Viento: "+this.viento+" km/h"+"\n"+
                "Sensación térmica min: "+this.sensacionTermicaMin+"ºC"+"\n"+
                "Sensación térmica max: "+this.sensacionTermicaMax+"ºC"+"\n"+
                "UV: "+this.UV;
}

}
