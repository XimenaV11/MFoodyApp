package com.ximena.mfoodyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText correoInicio;
    private EditText contraseñaInicio;
    private Button mButtonLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        correoInicio=findViewById(R.id.CorreoInicioS);
        contraseñaInicio=findViewById(R.id.ContraseñaInicioS);
        mButtonLogin=findViewById(R.id.button_Login);

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!correoInicio.getText().toString().isEmpty() && !contraseñaInicio.getText().toString().isEmpty()){
                    iniciosesion();
                }
            }
        });

    }
    public void irregistro(View v) {
        Intent registrar=new Intent(MainActivity.this,Registro.class);
        startActivity(registrar);
    }

    public void iniciosesion(){
        mAuth.signInWithEmailAndPassword(correoInicio.getText().toString(), contraseñaInicio.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Log.d(TAG, "signInWithEmail:success");
                                Toast.makeText(getApplicationContext(), "Inicio de sesion exitoso.",
                                        Toast.LENGTH_SHORT).show();

                                // Sign in success, update UI with the signed-in user's information

                                Intent continuar = new Intent(MainActivity.this, Navigator.class);
                                startActivity(continuar);
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Error inicio de sesion.",
                                        Toast.LENGTH_SHORT).show();
                                // updateUI(null);
                            }

                            // ...
                        }
                    });


    }
}