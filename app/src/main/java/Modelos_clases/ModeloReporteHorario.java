package Modelos_clases;

import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ModeloReporteHorario {


    private ArrayList<String> estadoCielo; //24 horas
    private ArrayList<String> temperatura; //24 horas
    private int hora;

    public ModeloReporteHorario(JSONObject jsonObjHorario) {
        try {
            JSONArray arraux1 = jsonObjHorario.getJSONArray("estadoCielo");
            //ESTADO CIELO
            for (int i = 0; i < arraux1.length(); i++) {
                System.out.println(arraux1.getJSONObject(i).getString("descripcion"));
                this.estadoCielo.add(arraux1.getJSONObject(i).getString("descripcion"));
            }

            JSONArray arraux2 = jsonObjHorario.getJSONArray("temperatura");
            //TEMPERATURA
            for (int i = 0; i < arraux2.length(); i++) {

                this.temperatura.add(arraux2.getJSONObject(i).getString("value"));
            }
        } catch (JSONException e) {
            System.out.println(e);
        }

    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String toString() {
        DateTimeFormatter dtf = null;
        String fecha_reporte = "";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            fecha_reporte = dtf.format(LocalDateTime.now());
        }
        String out = "";

        for (int i = 0; i < 24; i++) {
            out += i + ":00 horas , Estado del Cielo: " + estadoCielo.get(i) + ", Temperatura: " + temperatura.get(i) + "ºC " + "\n";
        }

        return "Fecha del Reporte: " + fecha_reporte + "\n" + out;
    }
}
