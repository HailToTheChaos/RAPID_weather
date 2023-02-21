package com.example.apptiempo;

import static com.example.apptiempo.Metodos.mostrarAlerta;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {
    private EditText intro_mail, intro_pwd;
    private Button boton_acceso;
    private TextView link_registro;
    private ProgressBar progressBar;
    private Switch interruptor;
    public static final String SHARED_PREFS ="sharedPrefs";

    FirebaseAuth myAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).hide();
        intro_mail = findViewById(R.id.email_login);
        intro_pwd = findViewById(R.id.password_login);
        boton_acceso = findViewById(R.id.boton_acceso);
        link_registro = findViewById(R.id.textview_crear);
        progressBar = findViewById(R.id.progressBar2);
        interruptor = findViewById(R.id.switch_rememberMe);

        myAuth = FirebaseAuth.getInstance();
        
        switchRemember();
    }

    private void switchRemember() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check = sp.getString("name","");
        if(check.equals("true")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void mandarRegistro(View view) {
        Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
        startActivity(intent);
    }

    public void acceder(View view) {
        String email = intro_mail.getText().toString();
        String password = intro_pwd.getText().toString();

        if (validar(email, password)) {
            progressBar.setVisibility(View.VISIBLE);
            myAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        if(isEmailVerificado(Objects.requireNonNull(myAuth.getCurrentUser()))) {
                            if(interruptor.isChecked()){
                                SharedPreferences sharedprefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                SharedPreferences.Editor edit = sharedprefs.edit();
                                edit.putString("name", "true");
                                edit.apply();
                            }
                            Toast.makeText(loginActivity.this, "Usuario identificado correctamente", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.INVISIBLE);
                            finish();
                        }
                    } else {
                        //Para debugging
                        mostrarAlerta("Email o correo no válido", loginActivity.this);
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }

    private boolean validar(String email, String password) {
        if (email.isEmpty()) {
            intro_mail.setError("Es necesario que introduzca el email");
            return false;
        }

        if (password.isEmpty()) {
            intro_pwd.setError("Es necesario que introduzca la contraseña");
            return false;
        }

        if (!email.matches(getString(R.string.match_correo))) {
            intro_mail.setError("Correo no válido");
            return false;
        }

        if (password.length() < 6 || password.length() > 20) {
            intro_pwd.setError("Es necesario que la contraseña tenga de 6 a 20 caracteres");
            return false;
        }

        return true;
    }

    private boolean isEmailVerificado(FirebaseUser user) {
        if (user.isEmailVerified()) {
            return true;
        } else {
            progressBar.setVisibility(View.INVISIBLE);
            mostrarAlerta("Debe de verificar el correo a través del enlace que le hemos enviado.",loginActivity.this);
            return false;
        }
    }

    public void abrirHelpPassword(View view) {
        Intent intent = new Intent(getApplicationContext(), HelpPassword.class);
        startActivity(intent);
    }
}