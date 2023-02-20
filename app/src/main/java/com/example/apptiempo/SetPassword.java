package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        contrasenya = findViewById(R.id.editText_contrasenya_nueva_setpassword);
        confirm_contrasenya = findViewById(R.id.editText_rep_contrasenya_setpassword);
        pass1 = contrasenya.getText().toString();
        conf_pass = confirm_contrasenya.getText().toString();
        myauth = FirebaseAuth.getInstance();
        idUsuario = myauth.getCurrentUser().getUid();
        myStore = FirebaseFirestore.getInstance();
        editText_contarsenya_propia = findViewById(R.id.editText_contarsenya_propia);
        contrasenya_prop = editText_contarsenya_propia.getText().toString();
        DocumentReference docRef = myStore.collection("usuarios").document(idUsuario);
        docRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                correo = value.getString("Email");
            }
        });
    }

    public void aceptar(View view) {
        if(comprobar_email()==true){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            AuthCredential credential = EmailAuthProvider.getCredential(correo,contrasenya_prop);

            user.reauthenticate(credential)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                user.updatePassword(pass1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SetPassword.this, "Contraseña cambiada correctamente", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(SetPassword.this, "No se pudo cambiar la contraseña.", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });
        }
    }

    private boolean comprobar_email(){

        if(contrasenya_prop.isBlank()){
            editText_contarsenya_propia.setError("No puede dejar este campo vacío.");
            return false;
        }
        if(pass1.isBlank()){
            contrasenya.setError("No puede dejar este campo vacío.");
            return false;
        }
        if(conf_pass.isBlank()){
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