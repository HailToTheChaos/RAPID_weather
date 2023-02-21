package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.Objects;

public class SetPassword extends AppCompatActivity {
    private String correo;
    private String contrasenya_prop;
    private String idUsuario;
    private FirebaseAuth myauth;
    private FirebaseFirestore myStore;
    private EditText contrasenya;
    private EditText confirm_contrasenya;
    private String pass1;
    private String conf_pass;
    private EditText editText_contarsenya_propia;
    private ProgressBar progressBar;


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        contrasenya = findViewById(R.id.editText_contrasenya_nueva_setpassword);
        confirm_contrasenya = findViewById(R.id.editText_rep_contrasenya_setpassword);
        myauth = FirebaseAuth.getInstance();
        idUsuario = Objects.requireNonNull(myauth.getCurrentUser()).getUid();
        myStore = FirebaseFirestore.getInstance();
        editText_contarsenya_propia = findViewById(R.id.editText_contarsenya_propia);
        progressBar = findViewById(R.id.progressBar_setPwd);
        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                assert value != null;
                correo = value.getString("Email");
            }
        });
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public void aceptar(View view) {
        contrasenya_prop = editText_contarsenya_propia.getText().toString();
        pass1 = contrasenya.getText().toString();
        conf_pass = confirm_contrasenya.getText().toString();

        if(comprobar_email(contrasenya_prop, pass1, conf_pass)){
            progressBar.setVisibility(View.VISIBLE);
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            AuthCredential credential = EmailAuthProvider.getCredential(correo,contrasenya_prop);

            assert user != null;
            user.reauthenticate(credential)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                user.updatePassword(pass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SetPassword.this, "Contraseña actualizada correctamente", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(SetPassword.this, "No se pudo cambiar. Intentelo más tarde", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
        }
    }

    private boolean comprobar_email(String contrasenya_prop, String pass1, String conf_pass){
        if(contrasenya_prop.isEmpty()){
            editText_contarsenya_propia.setError("No puede dejar este campo vacío.");
            return false;
        }
        if(pass1.isEmpty()){
            contrasenya.setError("No puede dejar este campo vacío.");
            return false;
        }
        if(conf_pass.isEmpty()){
            confirm_contrasenya.setError("No puede dejar este campo vacío.");
            return false;
        }
        if(!pass1.equals(conf_pass)){
            confirm_contrasenya.setError("La confirmación no coincide con la contraseña.");
            return false;
        }
        return true;
    }

}