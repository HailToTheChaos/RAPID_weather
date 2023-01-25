package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    EditText intro_mail, intro_pwd;
    Button boton_acceso;
    TextView link_registro;
    ProgressBar progressBar;

    FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intro_mail = findViewById(R.id.email_login);
        intro_pwd = findViewById(R.id.password_login);
        boton_acceso = findViewById(R.id.boton_acceso);
        link_registro = findViewById(R.id.textview_crear);
        progressBar = findViewById(R.id.progressBar2);

        myAuth = FirebaseAuth.getInstance();
    }


    public void mandarRegistro(View view) {
        Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
        startActivity(intent);
    }

    public void acceder(View view) {
        String email = intro_mail.getText().toString();
        String password = intro_pwd.getText().toString();

        if(validar(email, password)){
            progressBar.setVisibility(View.VISIBLE);
            myAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(loginActivity.this,"Usuario identificado correctamente",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.INVISIBLE);
                    } else {
                        //Para debugging
                        Toast.makeText(loginActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }

    private boolean validar(String email, String password){

        if(email.isEmpty()){
            intro_mail.setError("Es necesario que introduzca el email");
            return false;
        }

        if(password.isEmpty()){
            intro_pwd.setError("Es necesario que introduzca la contraseña");
            return false;
        }

        if(password.length() < 6){
            intro_pwd.setError("Es necesario que la contraseña tenga 6 o más carácteres");
            return false;
        }
        return true;
    }
}