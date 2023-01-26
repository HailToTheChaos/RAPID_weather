package com.example.apptiempo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import okhttp3.*;

public class MainActivity extends AppCompatActivity {
    Button boton_consultar;
    private String IDmunicipio;
    private static TextView textViewResult;
    private EditText edittext;
    private static ModeloReporte mr;
    FirebaseAuth myAuth;
    FirebaseFirestore myStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton_consultar = findViewById(R.id.boton_consultar);
        edittext = findViewById(R.id.editText_municipio);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void hacerConsulta(View view) throws IOException {


            getIDMunicipio(edittext.getText().toString().trim());

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
                    String enlace = MetodosJson.getURL(jsonobj);
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

    public void getIDMunicipio(String municipio_nombre) {
        myStore = FirebaseFirestore.getInstance();
//        String IDmunicipio = "";
//
//        try {
//            JsonParser parser = new JsonParser();
//
//            Object obj = parser.parse(br);
//            JSONArray array = null;
//            try {
//                array = new JSONArray(obj.toString());
//                br.close();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            for (int i = 0; i < array.length(); i++) {
//                try {
//                    if (array.getJSONObject(i).getString("nombre").equalsIgnoreCase(municipio_nombre)) {
//                        IDmunicipio = array.getJSONObject(i).getString("municipio_id");
//
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (ClassCastException | NullPointerException | IOException e) {
//            e.printStackTrace();
//        }

        DocumentReference docRef = myStore.collection("municipiosEspaña").document(municipio_nombre);

        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
               String resultado = value.getString("municipio_id");
                System.out.println(resultado);
                   getEnlaceHttpok(resultado);

            }
        });

    }
}
