package Modelos_clases;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModeloReporteGeneral {

    private TiempoActual tiempoActual;
    private String nombreMun;
    private ModeloReporteHorario modelosHorarios; //Serian 24, pero dependiendo de la hora de la consulta son menos
    ArrayList<ModeloReporteDiario> modelosDiarios; //Serian por 10 dias


    public ModeloReporteGeneral(String nombreMunicipio) {
        this.nombreMun = nombreMunicipio;
        modelosDiarios = new ArrayList();
    }



    public ModeloReporteHorario getModelosHorarios() {
        return modelosHorarios;
    }

    public void setModelosHorarios(JSONArray jsonArrayHorario) {

        try {
            JSONObject jObj = jsonArrayHorario.getJSONObject(0).getJSONObject("prediccion").getJSONArray("dia").getJSONObject(0);
            tiempoActual = new TiempoActual(jObj);
            modelosHorarios = new ModeloReporteHorario(jObj);
        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    public ArrayList<ModeloReporteDiario> getModelosDiarios() {
        return modelosDiarios;
    }

    public void setModelosDiarios(JSONArray jsonArrayDiario) {
        JSONArray jArr = null;
        try {
            jArr = jsonArrayDiario.getJSONObject(0).getJSONObject("prediccion").getJSONArray("dia");
            for (int i = 1; i < jArr.length() ; i++){
                modelosDiarios.add(new ModeloReporteDiario(jArr.getJSONObject(i)));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public String toString(){
        return this.nombreMun + "\n"+ this.modelosHorarios + "\n" + this.modelosDiarios.toString();
    }

    public TiempoActual getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(TiempoActual tiempoActual) {
        this.tiempoActual = tiempoActual;
    }
}
