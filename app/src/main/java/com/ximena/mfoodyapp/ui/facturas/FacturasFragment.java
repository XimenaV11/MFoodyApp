package com.ximena.mfoodyapp.ui.facturas;

import android.content.Intent;
import static android.content.Intent.getIntentOld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    ArrayList<FacturasItemList> factura;
    Button carrito;
    AdapterFacturas adapterFacturas;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View view = inflater.inflate(R.layout.fragment_facturas, container, false);
        setContentView(R.layout.fragment_facturas);

        //facturasViewModel =
                //new ViewModelProvider(this).get(FacturasViewModel.class);
        View root = binding.getRoot();
        factura= (ArrayList<FacturasItemList>)getIntent().getSerializableExtra("CarroCompras");
        facturas = binding.recyclerViewCompras;
        total = binding.texttotalc;
        adapterFacturas=new AdapterFacturas(factura,FacturasFragment.this,root,total);
        facturas.setAdapter(adapterFacturas);
        //FacturasFragment.this,factura,carrito,total,root

    }



}
