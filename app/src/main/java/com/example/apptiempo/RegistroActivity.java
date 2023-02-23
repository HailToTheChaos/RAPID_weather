package com.example.apptiempo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Objects;

public class RegistroActivity extends AppCompatActivity {
    private EditText intro_nombre, intro_mail, intro_pwd, intro_pwd_conf;
    private Button boton_registro;
    private TextView link_volver;
    private ProgressBar progressBar;
    private final String patronContraseña = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";

    private FirebaseAuth myAuth;
    private FirebaseFirestore myStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Objects.requireNonNull(getSupportActionBar()).hide();

        intro_nombre = findViewById(R.id.editText_nombre);
        intro_mail = findViewById(R.id.email_registro);
        intro_pwd = findViewById(R.id.contraseña_registro);
        intro_pwd_conf = findViewById(R.id.confi_contraseña_registro);
        boton_registro = findViewById(R.id.boton_registrar);
        link_volver = findViewById(R.id.textView_volver);
        progressBar = findViewById(R.id.progressBar);

        myAuth = FirebaseAuth.getInstance();
        myStore = FirebaseFirestore.getInstance();
        String idUsuario;
    }

    public void volverLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
        startActivity(intent);
    }

    public void registrar(View view) {
        String nombre = intro_nombre.getText().toString();
        String email = intro_mail.getText().toString();
        String password = intro_pwd.getText().toString();
        String password_conf = intro_pwd_conf.getText().toString();

        if (validaciones(email, password, password_conf)) {
            progressBar.setVisibility(View.VISIBLE);
            myAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //Si no ha habido problemas (la tarea de registrar el usuario ha sido exitosa: Feedback y redireccion a la MainActivity
                    if (task.isSuccessful()) {
                        String idUsuario = myAuth.getCurrentUser().getUid();
                        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);

                        HashMap<String,String> infoUsuario = new HashMap<>();
                        infoUsuario.put("Nombre",nombre);
                        infoUsuario.put("Email",email);
                        //metes la información del hashmap en el documento
                        docRef.set(infoUsuario);

                        sendVerificationEmail();
                        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                        Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente.", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        progressBar.setVisibility(View.INVISIBLE);
                    } else {
                        Toast.makeText(RegistroActivity.this,"Se ha producido une error en el proceso de registro.", Toast.LENGTH_SHORT ).show();
                        //Toast.makeText(RegistroActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }

    public boolean validaciones(String email, String password, String password_conf) {
        if (email.isEmpty()) {
            intro_mail.setError("El correo no puede estar vacio");
            return false;
        }

        if (password.isEmpty()) {
            intro_pwd.setError("La contraseña no puede estar vacio");
            return false;
        }

        if (password_conf.isEmpty()) {
            intro_pwd_conf.setError("La contraseña no puede estar vacio");
            return false;
        }

        if (password.length() < 6 || password.length() > 20) {
            intro_pwd.setError("Es necesario que la contraseña tenga de 6 a 20 caracteres");
            return false;
        }

        if (!password.equals(password_conf)) {
            intro_pwd_conf.setError("La contraseña no coincide");
            return false;
        }
        if(!password.matches(patronContraseña)){
            intro_pwd.setError("La contraseña debe contener por lo menos un dígito y un caracter en mayuscula");
            return false;
        }
        return true;
    }

    private void sendVerificationEmail(){
        FirebaseUser user = myAuth.getCurrentUser();
        if(user != null) {
            user.sendEmailVerification();
        }
    }

}