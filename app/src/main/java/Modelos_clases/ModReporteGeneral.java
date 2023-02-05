package Modelos_clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModReporteGeneral {

    ArrayList<ModeloReporteHorario> modelosHorarios; //Serian 24, pero dependiendo de la hora de la consulta son menos
    ArrayList<ModeloReporteDiario> modelosDiarios; //Serian por 10 dias

    /**
     * Constructor que genera el Modelo reporte general
     * @param jsonArrayHorario
     * @param jsonArrayDiario
     */
    public ModReporteGeneral(JSONArray jsonArrayHorario, JSONArray jsonArrayDiario) {
        try {
            JSONArray jArr = jsonArrayHorario.getJSONObject(0).getJSONObject("prediccion").getJSONArray("dia");

            for (int i = 0; i < jArr.length() ; i++){
                modelosHorarios.add(new ModeloReporteHorario(jArr.getJSONArray(i)));
            }

            JSONArray jArr2 = jsonArrayDiario.getJSONObject(0).getJSONObject("prediccion").getJSONArray("dia");

            for (int i = 0; i < jArr.length() ; i++){
                modelosHorarios.add(new ModeloReporteHorario(jArr.getJSONArray(i)));
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
