package com.example.apptiempo;


import static com.example.apptiempo.Metodos.mostrarAlerta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.*;

import org.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import Modelos_clases.*;
import okhttp3.*;

public class ConsultarTiempo extends AppCompatActivity implements IDMunicipioCallback {
    private String IDmunicipio;

    private TextView tv_municipio;

    private static ModeloReporteGeneral mrGeneral;
    FirebaseAuth myAuth;
    FirebaseFirestore myStore;
    String municipio;

    EditText edittext;
    ImageView estadoCielo;
    TextView infoActual, temperaturaActual, tempMaxima, tempMinima, tiempoHorario, info_horario, info_diario, tiempoDiario;
    ScrollView sv_tiempo;


    ArrayList<TextView> tViews;
    OkHttpClient client;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.config_item:
                Intent i = new Intent(getApplicationContext(),Configuracion.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_tiempo);


        edittext = findViewById(R.id.editText_municipio);
        tv_municipio = findViewById(R.id.tv_municipio);
        estadoCielo = findViewById(R.id.iv_estadoCielo);
        infoActual = findViewById(R.id.tv_InfoActual);
        temperaturaActual = findViewById(R.id.tv_temperatura);
        tempMaxima = findViewById(R.id.tv_temp_max);
        tempMinima = findViewById(R.id.tv_temp_min);
        tiempoHorario = findViewById(R.id.tv_tiempoHorario);
        tiempoDiario = findViewById(R.id.tv_tiempoDiario);
        info_horario = findViewById(R.id.info_tiempoHorario);
        info_diario = findViewById(R.id.info_tiempo_diario);
        sv_tiempo = findViewById(R.id.sv_infoTiempo);


        myStore = FirebaseFirestore.getInstance();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    public void hacerConsulta(View view) {
        municipio = edittext.getText().toString().trim().toLowerCase();
        getIDMunicipio(municipio, new IDMunicipioCallback() {
            @Override
            public void onIDMunicipioRetrieved(String id) {
                IDmunicipio = id;
                //controlamos que no nos devuelva vacío.
                if (IDmunicipio != null) {
                    mrGeneral = new ModeloReporteGeneral();
                    getEnlaceHttpok(IDmunicipio);

                    while (mrGeneral.getModelosHorarios() == null) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    while (mrGeneral.getModelosDiarios().size() == 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(mrGeneral);
                    mostrar();

                } else {
                    mostrarAlerta("No se encontró el municipio",ConsultarTiempo.this);
                }
            }
        });
    }

    private void mostrar() {
        tv_municipio.setText(mrGeneral.getNombreMun());
        infoActual.setText(mrGeneral.getTiempoActual().toString());

        runOnUiThread(new Runnable() {
            String estado;
            int hora;

            @Override
            public void run() {
                sv_tiempo.setVisibility(View.VISIBLE);
                estado = mrGeneral.getTiempoActual().getEstadoCielo();

                hora = Integer.parseInt(mrGeneral.getTiempoActual().getHora());
                System.out.println(mrGeneral.getTiempoActual().getTemperatura());
                temperaturaActual.setText(mrGeneral.getTiempoActual().getTemperatura());

                tempMaxima.setText(mrGeneral.getModelosDiarios().get(0).getTemp_max());
                tempMinima.setText(mrGeneral.getModelosDiarios().get(0).getTemp_min());
                info_horario.setVisibility(View.VISIBLE);
                tiempoHorario.setText(mrGeneral.getModelosHorarios().toString());

                info_diario.setVisibility(View.VISIBLE);
                tiempoDiario.setText(mrGeneral.obtenerTiempoModelosDiarios());

                if (hora <= 20) {
                    if (estado.equals("despejado")) {
                        estadoCielo.setImageResource(R.drawable.ic_despejado);
                    } else if (estado.contains("nieve")) {
                        estadoCielo.setImageResource(R.drawable.ic_nieve);
                    } else if (estado.contains("cubierto")) {
                        estadoCielo.setImageResource(R.drawable.ic_nubes);
                    } else if (estado.contains("nuboso") || estado.contains("nubes")) {
                        if (estado.equalsIgnoreCase("muy nuboso")) {
                            estadoCielo.setImageResource(R.drawable.ic_nubes);
                        } else {
                            estadoCielo.setImageResource(R.drawable.ic_poco_nuboso);
                        }
                    }

                } else {
                    if (estado.equals("despejado")) {
                        estadoCielo.setImageResource(R.drawable.ic_luna);
                    } else if (estado.contains("nieve")) {
                        estadoCielo.setImageResource(R.drawable.ic_nieve);
                    }else if (estado.equalsIgnoreCase("cubierto")) {
                        estadoCielo.setImageResource(R.drawable.ic_nubes);
                    } else if (estado.contains("nuboso") || estado.contains("nubes")) {
                        if (estado.equalsIgnoreCase("muy nuboso")) {
                            estadoCielo.setImageResource(R.drawable.ic_nubes);
                        } else {
                            estadoCielo.setImageResource(R.drawable.ic_poco_nuboso_noche);
                        }
                    }

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

        requestTiempo(request1, "diario");

        Request request2 = new Request.Builder()
                .url("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/horaria/" + IDMunicipio)
                .method("GET", null)
                .addHeader("api_key", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqYWltZWRlbGFmdWVudGUyNUBvdXRsb29rLmVzIiwianRpIjoiYjMyMTA3YTctNjAwZS00MTBiLTlkNWMtOTAxN2FkMWM2MTc0IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NzQ3NDQ1OTgsInVzZXJJZCI6ImIzMjEwN2E3LTYwMGUtNDEwYi05ZDVjLTkwMTdhZDFjNjE3NCIsInJvbGUiOiIifQ.51Y4dwn7sS7ePdcJEnfEUvdCIAcicDeA_pdIK6sfBbM")
                .build();

        //Metemos la request en cola

        requestTiempo(request2, "horario");

    }

    /**
     * Método que hace la request inicial a AEMET para conseguir el enlace que contiene el JSON del tiempo
     * @param request (cogemos la request ya preparada)
     * @param tipo (Si es diaria o horaria)
     */
    private void requestTiempo(Request request, String tipo) {

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
                    if (tipo.equalsIgnoreCase("diario")) {
                        getTiempoDiario(enlace);
                    } else if (tipo.equalsIgnoreCase("horario")) {
                        getTiempoHorario(enlace);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Método para obtener el tiempo por horas
     * @param enlace
     */
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
                        mrGeneral.setModelosHorarios(jsonarr);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("No se encontraron datos del tiempo horario");
            }
        });
    }

    /**
     * Método para obtener el tiempo por días
     * @param enlace
     */
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

    /**
     * Método para obtener el ID del municipio de Firebase
     * @param municipio_nombre
     * @param callback
     */
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

                    public void onFailure(DocumentSnapshot documentSnapshot) {

                    }
                });
    }

    @Override
    public void onIDMunicipioRetrieved(String id) {

    }

}
