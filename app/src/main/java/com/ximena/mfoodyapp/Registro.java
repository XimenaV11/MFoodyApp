package com.ximena.mfoodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button botonGuardarR=(Button) findViewById(R.id.button3);
        botonGuardarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar=new Intent(Registro.this,Navigator.class);
                startActivity(registrar);
            }
        });
    }
}