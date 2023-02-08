package com.example.apptiempo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import Modelos_clases.*;
import okhttp3.*;

public class ConsultarTiempo extends AppCompatActivity implements IDMunicipioCallback {
    private String IDmunicipio;

    private static ModeloReporteGeneral mrGeneral;
    FirebaseAuth myAuth;
    FirebaseFirestore myStore;
    String municipio;

    EditText edittext;

    ArrayList<TextView> tViews;
    OkHttpClient client;
//    SearchView buscador;
//    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_tiempo);

//        buscador = findViewById(R.id.busquedaMunicipio);


//        search_view();
        edittext = findViewById(R.id.editText_municipio);
        myStore = FirebaseFirestore.getInstance();


    }

//    private void search_view() {
//        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                textSearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//    }

//    private void textSearch(String entrada){
//        Query query = myStore.collection("municipiosEspaña")
//                .orderBy("name").startAt(entrada).endAt(entrada+"~");
//
//        FirestoreRecyclerOptions<Municipio> firestoreRecyclerOptions =
//                new FirestoreRecyclerOptions.Builder<Municipio>()
//                        .setQuery(query,Municipio.class).build();
//
//    }

    public void hacerConsulta(View view) {

        municipio = Metodos.capitalize(edittext.getText().toString().trim());
        getIDMunicipio(municipio, new IDMunicipioCallback() {
            @Override
            public void onIDMunicipioRetrieved(String id) {
                IDmunicipio = id;
                //controlamos que no nos devuelva vacío.
                if (IDmunicipio!=null) {
                    mrGeneral = new ModeloReporteGeneral(municipio);
                    getEnlaceHttpok(IDmunicipio);
                    System.out.println(mrGeneral);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("No se encontro el municipio").create().show();

                }
            }
        });
    }


    /**
     * Método para obtener el enlace con el tiempo de AEMET
     *
     * @param IDMunicipio
     */
    public void getEnlaceHttpok(String IDMunicipio) {
        //Creamos la request y en el builder le metemos la url, el metodo GET y el header(La api key)
        Request request1 = new Request.Builder()
                .url("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/" + IDMunicipio)
                .method("GET", null)
                .addHeader("api_key", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYWltZWRlbGFmdWVudGUyNUBvdXRsb29rLmVzIiwianRpIjoiYjMyMTA3YTctNjAwZS00MTBiLTlkNWMtOTAxN2FkMWM2MTc0IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NzQ3NDQ1OTgsInVzZXJJZCI6ImIzMjEwN2E3LTYwMGUtNDEwYi05ZDVjLTkwMTdhZDFjNjE3NCIsInJvbGUiOiIifQ.51Y4dwn7sS7ePdcJEnfEUvdCIAcicDeA_pdIK6sfBbM")
                .build();

        requestTiempo(request1,"diario");



        Request request2 = new Request.Builder()
                .url("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/horaria/" + IDMunicipio)
                .method("GET", null)
                .addHeader("api_key", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYWltZWRlbGFmdWVudGUyNUBvdXRsb29rLmVzIiwianRpIjoiYjMyMTA3YTctNjAwZS00MTBiLTlkNWMtOTAxN2FkMWM2MTc0IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NzQ3NDQ1OTgsInVzZXJJZCI6ImIzMjEwN2E3LTYwMGUtNDEwYi05ZDVjLTkwMTdhZDFjNjE3NCIsInJvbGUiOiIifQ.51Y4dwn7sS7ePdcJEnfEUvdCIAcicDeA_pdIK6sfBbM")
                .build();

        //Metemos la request en cola

        System.out.println(mrGeneral);
    }

    private void requestTiempo(Request request, String tipo){

        //Instanciamos el cliente OkHttp
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("No se encontraron datos");
            }

            //Si la respuesta devuelve
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonData = response.body().string();
                try {
                    JSONObject jsonobj = new JSONObject(jsonData);
                    String enlace = Metodos.getURL(jsonobj);
                    if(tipo.equalsIgnoreCase("diario")) {
                        getTiempoDiario(enlace);
                    } else if(tipo.equalsIgnoreCase("horario")){
                        getTiempoHorario(enlace);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getTiempoHorario(String enlace) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(enlace)
                .method("GET", null)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonData = response.body().string();
                    try {
                        JSONArray jsonarr = new JSONArray(jsonData);
//                        mrGeneral.setModelosHorarios(jsonarr);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }
        });
    }

    private static void getTiempoDiario(String enlace) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(enlace)
                .method("GET", null)
                .build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {

                    String jsonData = response.body().string();
                    try {
                        JSONArray jsonarr = new JSONArray(jsonData);
                        mrGeneral.setModelosDiarios(jsonarr);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }
        });
    }

    public void getIDMunicipio(String municipio_nombre, IDMunicipioCallback callback) {


        ArrayList<String> idmunicipio = new ArrayList<>();
        myStore.collection("municipiosEspaña").document(municipio_nombre)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        idmunicipio.add(documentSnapshot.getString("municipio_id"));
                        //hago uso de mi interfaz para evitar asincronización.
                        callback.onIDMunicipioRetrieved(idmunicipio.get(idmunicipio.size() - 1));
                    }

                    public void onFailure(DocumentSnapshot documentSnapshot){

                    }
                });
    }

    @Override
    public void onIDMunicipioRetrieved(String id) {

    }

}
