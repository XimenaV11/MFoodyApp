package com.ximena.mfoodyapp.ui.facturas;

import android.annotation.SuppressLint;
import android.content.Intent;
import static android.content.Intent.getIntentOld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentFacturasBinding;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;

import java.util.ArrayList;
import java.util.List;


public class FacturasFragment extends AppCompatActivity {
    private FacturasViewModel facturasViewModel;
    private FragmentFacturasBinding binding;
    //AdapterCompras adapterCompras;
    RecyclerView facturas;
    TextView total;
    TextView titulo2;
    TextView precio2;
    EditText cantidad2;
    ArrayList<FacturasItemList> factura;
    Button carrito;
    AdapterFacturas adapterFacturas;
    private  View root;


    @SuppressLint("WrongViewCast")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View view = inflater.inflate(R.layout.fragment_facturas, container, false);
        setContentView(R.layout.fragment_facturas);
        FacturasItemList elements = (FacturasItemList) getIntent().getSerializableExtra("FacturasItemList");

        //facturasViewModel =
                //new ViewModelProvider(this).get(FacturasViewModel.class);

       // factura= (ArrayList<FacturasItemList>)getIntent().getSerializableExtra("CarroCompras");
        facturas = findViewById(R.id.recyclerViewCompras);
        cantidad2=findViewById(R.id.textcantidad2);
        titulo2=findViewById(R.id.txtTitulo2);
        precio2=findViewById(R.id.textPrecio2);
        
        total = findViewById(R.id.textTotalc);
       // titulo_titulo.setText(element.getNombre());
        titulo2.setText(elements.getNombreComida());
        cantidad2.setText(elements.getCantidad());
        precio2.setText(elements.getPreciosub());
        
        adapterFacturas=new AdapterFacturas(factura,FacturasFragment.this,root,total);
        facturas.setAdapter(adapterFacturas);
        //FacturasFragment.this,factura,carrito,total,root

    }



}
