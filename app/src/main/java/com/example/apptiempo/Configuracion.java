package com.example.apptiempo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Configuracion extends AppCompatActivity {

    private FirebaseAuth myauth;
    private FirebaseFirestore myStore;
    private String idUsuario;
    private TextView nombre;
    private TextView correo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        myauth = FirebaseAuth.getInstance();
        idUsuario = myauth.getCurrentUser().getUid();
        myStore = FirebaseFirestore.getInstance();
        nombre = findViewById(R.id.textView_nombre_configuracion);
        correo = findViewById(R.id.textView_correo_configuracion);
        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                nombre.setText(value.getString("Nombre"));
                correo.setText(value.getString("Email"));
            }
        });
    }

    public void cambiar_contrasenya(View view) {
        Intent intent = new Intent(getApplicationContext(),SetPassword.class);
        startActivity(intent);
    }
}