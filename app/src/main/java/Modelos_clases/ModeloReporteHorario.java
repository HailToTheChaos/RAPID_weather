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
    private ArrayList<String> horasEstado;


    public ModeloReporteHorario(JSONObject jsonObjHorario) {

        estadoCielo = new ArrayList<>();
        temperatura = new ArrayList<>();
        horasEstado = new ArrayList<>();
        try {
            JSONArray arraux1 = jsonObjHorario.getJSONArray("estadoCielo");
            //ESTADO CIELO
            for (int i = 1; i < arraux1.length(); i++) {
                this.estadoCielo.add(arraux1.getJSONObject(i).getString("descripcion"));
                this.horasEstado.add(arraux1.getJSONObject(i).getString("periodo"));
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

    @Override
    public String toString() {

        String out = "";

        for (int i = 0; i < estadoCielo.size(); i++) {
            out += horasEstado.get(i) + ":00. " + estadoCielo.get(i) + ", " + temperatura.get(i) + "ºC " + "\n";
        }

        return out;
    }
}
