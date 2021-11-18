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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ximena.mfoodyapp.persistence.entidades.User;

import static android.content.ContentValues.TAG;


public class Registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private EditText correoR;
    private EditText contrasenaR;
    private EditText contrasenaRC;
    private EditText nombres;
    private EditText apellidos;
    private Object AuthResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
        correoR=findViewById(R.id.CorreoRegistro);
        contrasenaR=findViewById(R.id.ContraseñaRegistro);
        contrasenaRC=findViewById(R.id.ContraseñaRegistroConf);
        nombres=findViewById(R.id.Nombres);
        apellidos=findViewById(R.id.Apellidos);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);

    }

        public void Registrarusuario (View v){

        if (contrasenaR.getText().toString().equals(contrasenaRC.getText().toString())){
            if (contrasenaR.length()>6) {
                if (nombres.getText().toString().isEmpty()||apellidos.getText().toString().isEmpty()||correoR.getText().toString().isEmpty()){
                    Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
                }else {

                    mAuth.createUserWithEmailAndPassword(correoR.getText().toString(), contrasenaR.getText().toString())
                            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(getApplicationContext(), "Creacion de usuario exitosa.",
                                                Toast.LENGTH_SHORT).show();
                                        User usercreado=new User(nombres,apellidos,correoR);
                                        db.collection("users").add(usercreado)
                                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                            @Override
                                            public void onSuccess(DocumentReference documentReference) {
                                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                                Intent registrar = new Intent(Registro.this, MainActivity.class);
                                                startActivity(registrar);
                                                Toast.makeText(getApplicationContext(), "Creacion de coleccion exitosa.",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Log.w(TAG, "Error adding document", e);
                                                        Snackbar.make(v,R.string.ERROR_COLECCION,Snackbar.LENGTH_LONG).show();
                                                        Toast.makeText(getApplicationContext(), "Creacion de COLECCION FALLIDA.",
                                                                Toast.LENGTH_SHORT).show();
                                                    }
                                                });

                                        //updateUI(user);


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(getApplicationContext(), "Error en la autenticacion de datos.",
                                                Toast.LENGTH_SHORT).show();
                                        //updateUI(null);
                                    }
                                }
                            });
                }
                } else{
                    Toast.makeText(this, "La contraseña debe ser mayor a 6 digitos", Toast.LENGTH_SHORT).show();

                }
            } else{
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();

            }


    }
}

