package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Locale;
import java.util.Objects;

public class Configuracion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private FirebaseAuth myauth;
    private FirebaseFirestore myStore;
    private String idUsuario;
    private TextView nombre;
    private TextView correo;
    private Spinner sLenguaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        myauth = FirebaseAuth.getInstance();
        idUsuario = myauth.getCurrentUser().getUid();
        myStore = FirebaseFirestore.getInstance();
        nombre = findViewById(R.id.textView_nombre_configuracion);
        correo = findViewById(R.id.textView_correo_configuracion);
        sLenguaje = findViewById(R.id.spinnerIdioma);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.language_option, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLenguaje.setAdapter(adapter);
        sLenguaje.setOnItemSelectedListener(this);

        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                nombre.setText(value.getString("Nombre"));
                correo.setText(value.getString("Email"));
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    public void cambiar_contrasenya(View view) {
        Intent intent = new Intent(getApplicationContext(),SetPassword.class);
        startActivity(intent);
    }

    public void eliminar_cuenta(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Configuracion.this);
        alertDialog.setMessage("¿Desea eliminar la cuenta?");
        alertDialog.setTitle("Eliminar cuenta");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                myStore.collection("usuarios").document(idUsuario)
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "No se pudo eliminar la cuenta.", Toast.LENGTH_SHORT).show();
                            }
                        });
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                user.delete()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    SharedPreferences sharedprefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
                                    SharedPreferences.Editor edit = sharedprefs.edit();
                                    edit.putString("name", "");
                                    edit.apply();
                                    Intent i = new Intent(getApplicationContext(),loginActivity.class);
                                    startActivity(i);
                                    finish();
                                    Toast.makeText(getApplicationContext(), "Cuenta eliminada.", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(),"No se pudo eliminar la cuenta", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        alertDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String lang= parent.getItemAtPosition(position).toString();

        if(lang.equals("Español")){
            cambiarIdioma("es");
        }else if(lang.equals("English")) {
            cambiarIdioma("en");
        }
    }

    private void cambiarIdioma(String idioma){
        Resources res = Configuracion.this.getResources();
        DisplayMetrics en = res.getDisplayMetrics();
        android.content.res.Configuration enf = res.getConfiguration();
        enf.locale = new Locale(idioma);
        res.updateConfiguration(enf,en);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}