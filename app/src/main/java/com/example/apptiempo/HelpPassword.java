package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class HelpPassword extends AppCompatActivity {

    private EditText gmail;
    private Button recuperar;
    private FirebaseAuth auth;
    private String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_password);
        gmail = findViewById(R.id.edittext_gmail_recuperar);
        recuperar = findViewById(R.id.button_recuperar);
        auth = FirebaseAuth.getInstance();
    }

    public void volverLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), loginActivity.class);
        startActivity(intent);
    }

    private void getEnviarCorreo() {
        auth.setLanguageCode("es");
        auth.sendPasswordResetEmail(correo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Por favor revise su correo para restaurar su contraseña", Toast.LENGTH_LONG).show();

                    finish();
                }
            }
        });
    }

    private boolean validar_correo(@NonNull String mail) {
        if (!mail.matches(getString(R.string.match_correo))) {
            gmail.setError("Por favor, introduzca un formato correcto de correo.");
            return false;
        }

        if (mail.isEmpty()) {
            gmail.setError("No puede dejar este apartado en blanco");
            return false;
        }
        return true;
    }

    public void recuperarPassword(View view) {
        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = gmail.getText().toString().trim();
                if (validar_correo(correo) == true) {
                    getEnviarCorreo();
                } else {
                    Toast.makeText(getApplicationContext(), "Error, el correo no se pudo enviar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}