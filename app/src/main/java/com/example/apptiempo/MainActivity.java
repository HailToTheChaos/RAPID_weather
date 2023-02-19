package com.example.apptiempo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth myauth;
    private FirebaseFirestore myStore;
    private String idUsuario;
    private TextView bienvenida;

    public static final String SHARED_PREFS ="sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myauth = FirebaseAuth.getInstance();
        idUsuario = myauth.getCurrentUser().getUid();
        myStore = FirebaseFirestore.getInstance();
        bienvenida = findViewById(R.id.textView_bienvenida);
        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                bienvenida.setText("Bienvenido a tu sesión " + value.getString("Nombre") + "\n¿Qué desea realizar?");
            }
        });
    }

    public void consultarTiempo(View view) {
        Intent intent = new Intent(getApplicationContext(), ConsultarTiempo.class);
        startActivity(intent);
    }


    public void cerrar_sesion(View view) {
        SharedPreferences sharedprefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedprefs.edit();
        edit.putString("name", "");
        edit.apply();
        if (myauth != null && myStore != null) {
            myauth.signOut();
            myStore.terminate();
            Toast.makeText(this, "Cerrando sesión.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), loginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error al cerrar sesión.", Toast.LENGTH_SHORT).show();
        }
    }
}