package com.ximena.mfoodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton=(Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario= ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
                String contrasena=((EditText)findViewById(R.id.editTextTextPassword)).getText().toString();
                if (usuario.equals("admin") && contrasena.equals("admin"))
                {
                    Intent continuar=new Intent(MainActivity.this,Navigator.class);
                    startActivity(continuar);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button botonRegistro=(Button) findViewById(R.id.button2);
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent registrar=new Intent(MainActivity.this,Registro.class);
                    startActivity(registrar);
            }
        });
    }
}