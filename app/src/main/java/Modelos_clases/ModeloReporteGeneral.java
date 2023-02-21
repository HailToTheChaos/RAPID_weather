package Modelos_clases;

import org.json.*;

import java.util.ArrayList;

public class ModeloReporteGeneral {
    private TiempoActual tiempoActual;
    private String nombreMun;
    private ModeloReporteHorario modelosHorarios; //Serian 24, pero dependiendo de la hora de la consulta son menos
    ArrayList<ModeloReporteDiario> modelosDiarios; //Serian por 10 dias


    public ModeloReporteGeneral() {
        modelosDiarios = new ArrayList();
    }



    public ModeloReporteHorario getModelosHorarios() {
        return modelosHorarios;
    }

    public void setModelosHorarios(JSONArray jsonArrayHorario) {
        try {
            this.nombreMun = jsonArrayHorario.getJSONObject(0).getString("nombre");
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

    public String obtenerTiempoModelosDiarios(){
        String out = "";
        for (int i = 0; i < this.modelosDiarios.size(); i++) {
            out += modelosDiarios.get(i);
        }
        return out;
    }

    public void setModelosDiarios(JSONArray jsonArrayDiario) {
        JSONArray jArr = null;
        try {
            jArr = jsonArrayDiario.getJSONObject(0).getJSONObject("prediccion").getJSONArray("dia");
            for (int i = 0; i < jArr.length() ; i++){
                modelosDiarios.add(new ModeloReporteDiario(jArr.getJSONObject(i)));
            }
        } catch (JSONException e) {
            System.out.println("Error setModelosDiarios(general) "+ e);
        }
    }



    @Override
    public String toString(){
        return this.nombreMun + "\n"+ this.modelosHorarios + "\n" + this.modelosDiarios.toString();
    }

    public String getNombreMun() {
        return nombreMun;
    }

    public TiempoActual getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(TiempoActual tiempoActual) {
        this.tiempoActual = tiempoActual;
    }
}
