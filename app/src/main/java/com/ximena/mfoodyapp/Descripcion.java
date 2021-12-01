package com.ximena.mfoodyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.core.View;
import com.ximena.mfoodyapp.databinding.FragmentDescripcionBinding;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;
import com.ximena.mfoodyapp.ui.facturas.FacturasFragment;
import com.ximena.mfoodyapp.ui.facturas.FacturasItemList;

import java.io.Serializable;
import java.util.ArrayList;


public class Descripcion extends AppCompatActivity {

    TextView titulo_titulo;
    TextView titulo_descripcion;
    TextView Precio;
    ImageView ImageDesc;
    TextView cantidadpedidos;
    Button carrito;
    Button btnvercarro;
    Context context;
    private ItemListEspecial object;
    public ArrayList<FacturasItemList> factura;

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
        carrito=findViewById(R.id.buttoncarrito);
        btnvercarro=findViewById(R.id.vercarro);


        titulo_titulo.setText(element.getNombre());
        titulo_descripcion.setText(element.getDescripcion());
        ImageDesc.setImageResource(element.getImagen());
        Precio.setText(element.getPrecio());
        cantidadpedidos.setText(String.valueOf(cantidadpedidos));

        carrito.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(getApplicationContext(), "Añadido correctamente a tu carrito ", Toast.LENGTH_SHORT).show();

            }


        });
        btnvercarro.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent=new Intent(Descripcion.this, FacturasFragment.class);
                intent.putExtra("CarroCompras",(Serializable) factura);
                startActivity(intent);

            }
        });




    }
    public void BotonMas(View view){
        //cantidadpedidos=cantidadpedidos+1;


    }
    public void BotonMenos(View view){

    }





}