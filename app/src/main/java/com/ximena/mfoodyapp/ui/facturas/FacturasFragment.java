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
import androidx.recyclerview.widget.LinearLayoutManager;
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
    RecyclerView recyclerviewfacturas;
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
        //FacturasItemList elements = (FacturasItemList) getIntent().getSerializableExtra("CarroCompras");

        //facturasViewModel =
                //new ViewModelProvider(this).get(FacturasViewModel.class);

       // factura= (ArrayList<FacturasItemList>)getIntent().getSerializableExtra("CarroCompras");
        recyclerviewfacturas = findViewById(R.id.recyclerViewCompras);
        cantidad2=findViewById(R.id.textcantidad2);
        titulo2=findViewById(R.id.txtTitulo2);
        precio2=findViewById(R.id.textPrecio2);
        total = findViewById(R.id.textTotalc);
        //Bundle recibedatos=getIntent().getExtras();
        String title;
        String price;
        String count;
       // titulo_titulo.setText(element.getNombre());
        /*titulo2.setText(elements.getNombreComida());
        cantidad2.setText(elements.getCantidad());
        precio2.setText(elements.getPreciosub());*/
        //titulo2.setText(recibedatos.getString("titulo"));
        //cantidad2.setText(recibedatos.getString("cantidad"));
        //precio2.setText(recibedatos.getString("precio"));
        //total=(cantidad2*precio2);
        
        adapterFacturas=new AdapterFacturas(factura,FacturasFragment.this,root);
        recyclerviewfacturas.setAdapter(adapterFacturas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerviewfacturas.setLayoutManager(linearLayoutManager);
        //FacturasFragment.this,factura,carrito,total,root

    }



}
