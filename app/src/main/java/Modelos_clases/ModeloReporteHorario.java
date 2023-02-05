package Modelos_clases;

import org.json.JSONArray;

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

    }
}
