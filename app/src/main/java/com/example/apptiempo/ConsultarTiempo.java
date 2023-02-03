package com.example.apptiempo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import okhttp3.*;

public class ConsultarTiempo extends AppCompatActivity implements IDMunicipioCallback {
    Button boton_consultar;
    private String IDmunicipio;
    private static TextView textViewResult;
    private EditText edittext;
    private static ModeloReporte mr;
    FirebaseAuth myAuth;
    FirebaseFirestore myStore;
    String municipio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_tiempo);

        boton_consultar = findViewById(R.id.boton_consultar);
        edittext = findViewById(R.id.editText_municipio);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void hacerConsulta(View view) {
        municipio = Metodos.capitalize(edittext.getText().toString().trim());
        getIDMunicipio(municipio, new IDMunicipioCallback() {
            @Override
            public void onIDMunicipioRetrieved(String id) {
                IDmunicipio = id;
                //controlamos que no nos devuelva vacío.
                if (IDmunicipio!=null) {
                    getEnlaceHttpok(IDmunicipio);
                } else {
                    textViewResult.setText("No se encontraron datos");
                }
            }
        });
    }


    /**
     * Método para obtener el enlace con el tiempo de AEMET
     *
     * @param IDMunicipio
     */
    public static void getEnlaceHttpok(String IDMunicipio) {
        //Instanciamos el cliente OkHttp
        OkHttpClient client = new OkHttpClient();

        //Creamos la request y en el builder le metemos la url, el metodo GET y el header(La api key)
        Request request = new Request.Builder()
                .url("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/" + IDMunicipio)
                .method("GET", null)
                .addHeader("api_key", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYWltZWRlbGFmdWVudGUyNUBvdXRsb29rLmVzIiwianRpIjoiYjMyMTA3YTctNjAwZS00MTBiLTlkNWMtOTAxN2FkMWM2MTc0IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NzQ3NDQ1OTgsInVzZXJJZCI6ImIzMjEwN2E3LTYwMGUtNDEwYi05ZDVjLTkwMTdhZDFjNjE3NCIsInJvbGUiOiIifQ.51Y4dwn7sS7ePdcJEnfEUvdCIAcicDeA_pdIK6sfBbM")
                .build();

        //Metemos la request en cola
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                textViewResult.setText("Error al hacer la consulta");
            }

            //Si la respuesta devuelve
            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()) {
                String jsonData = response.body().string();
                try {
                    JSONObject jsonobj = new JSONObject(jsonData);
                    String enlace = Metodos.getURL(jsonobj);
                    getTiempo(enlace);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                }
            }
        });

    }

    private static void getTiempo(String enlace) {
        OkHttpClient client2 = new OkHttpClient();

        Request request = new Request.Builder()
                .url(enlace)
                .method("GET", null)
                .build();

        client2.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonData = response.body().string();
                    try {
                        JSONArray jsonarr = new JSONArray(jsonData);
                        mr = new ModeloReporte(jsonarr);
                        textViewResult.setText(mr.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                textViewResult.setText("Error al hacer la consulta");
            }
        });
    }

    public void getIDMunicipio(String municipio_nombre, IDMunicipioCallback callback) {
        myStore = FirebaseFirestore.getInstance();

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
