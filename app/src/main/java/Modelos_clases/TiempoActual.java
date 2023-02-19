package Modelos_clases;

import androidx.annotation.NonNull;

import com.example.apptiempo.Metodos;

import org.json.*;

import java.time.LocalDateTime;

public class TiempoActual {
    private String hora;
    private String temperatura;
    private String estadoCielo;
    private String precipitacion;
    private String sensTermica;
    private String velocidadViento;
    private String direcionViento;
    //precipitacion en mm
    //velocidad en km/h
    //probabilidad en %


    /**
     * Contructor del objeto tiempo actual
     * @param jObj (JsonObject de la consulta a la API)
     */
    public TiempoActual(JSONObject jObj) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime locaDate = LocalDateTime.now();
            String horaStr = String.valueOf(locaDate.getHour());

            if (horaStr.length() == 1) {
                this.hora = "0" + horaStr;
            } else {
                this.hora = horaStr;
            }
        }
        try {
            this.temperatura = obtenerValor(jObj.getJSONArray("temperatura")) + "º";
            this.estadoCielo = obtenerDescripcion(jObj.getJSONArray("estadoCielo")).toLowerCase();
            this.precipitacion = obtenerValor(jObj.getJSONArray("precipitacion")) + " mm";
            this.sensTermica = obtenerValor(jObj.getJSONArray("sensTermica")) + "º C";
            obtenerViento(jObj.getJSONArray("vientoAndRachaMax"));


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    private String obtenerValor(JSONArray jArray) {
        String valor = "";
        try {
            for (int i = 0; i < jArray.length(); i++) {
                if (jArray.getJSONObject(i).getString("periodo").equals(this.hora)) {
                    valor = jArray.getJSONObject(i).getString("value");
                }
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return valor;
    }

    private String obtenerDescripcion(JSONArray jArray) {
        String valor = "";
        try {
            for (int i = 0; i < jArray.length(); i++) {

                if (jArray.getJSONObject(i).getString("periodo").equals(this.hora)) {
                    valor = jArray.getJSONObject(i).getString("descripcion");
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return valor;
    }

    private void obtenerViento(JSONArray jArray) {
        try {
            for (int i = 0; i < jArray.length(); i++) {

                if (jArray.getJSONObject(i).getString("periodo").equals(this.hora)) {
                    try {
                        this.direcionViento = jArray.getJSONObject(i).getJSONArray("direccion").getString(0);
                    } catch (JSONException ex) {
                        this.direcionViento = "";
                    }
                    this.velocidadViento = jArray.getJSONObject(i).getJSONArray("velocidad").getString(0) + " km/h";
                }
            }
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    public String getHora() {
        return hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getEstadoCielo() {
        return estadoCielo;
    }

    public String getPrecipitacion() {
        return precipitacion;
    }

    public String getSensTermica() {
        return sensTermica;
    }

    public String getVelocidadViento() {
        return velocidadViento;
    }

    public String getDirecionViento() {
        return direcionViento;
    }

    @NonNull
    @Override
    public String toString() {
        return Metodos.capitalize(estadoCielo) + "\n" +
                "Precipitación: " + precipitacion + ". Sensación térmica: "
                + sensTermica + ".\nVelocidad del viento: " + velocidadViento + " " + direcionViento;
    }
}
