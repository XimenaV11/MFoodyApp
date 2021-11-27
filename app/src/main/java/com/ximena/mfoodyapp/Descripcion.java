package com.ximena.mfoodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.core.View;
import com.ximena.mfoodyapp.databinding.FragmentDescripcionBinding;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;


public class Descripcion extends AppCompatActivity {

    TextView titulo_titulo;
    TextView titulo_descripcion;
    TextView Precio;
    ImageView ImageDesc;
    TextView cantidadpedidos;
    private ItemListEspecial object;

    //private PerfilViewModel perfilViewModel;
    //private FragmentDescripcionBinding binding;


    @SuppressLint("WrongViewCast")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_descripcion);
        ItemListEspecial element = (ItemListEspecial) getIntent().getSerializableExtra("ItemListEspecial");
        //ItemListEspecial element=(ItemListEspecial) getIntent().getSerializableExtra("ItemListEspecial");
        titulo_titulo = findViewById(R.id.titulo_titulo);
        titulo_descripcion = findViewById(R.id.text_descripcion);
        ImageDesc = findViewById(R.id.imageDespcription);
        Precio=findViewById(R.id.precioDetalle);
        cantidadpedidos=findViewById(R.id.cantidadpe);


        titulo_titulo.setText(element.getNombre());
        titulo_descripcion.setText(element.getDescripcion());
        ImageDesc.setImageResource(element.getImagen());
        Precio.setText(element.getPrecio());
        cantidadpedidos.setText(String.valueOf(cantidadpedidos));






    }
    public void BotonMas(View view){
        //cantidadpedidos=cantidadpedidos+1;


    }
    public void BotonMenos(View view){

    }





}