package com.ximena.mfoodyapp.ui.frios;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentFriosBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;
import com.ximena.mfoodyapp.ui.facturas.FacturasItemList;

import java.util.ArrayList;


public class FriosFragment extends Fragment {
    private RecyclerView recyclerViewFrios;
    AdapterEspecial adapterEspecial;
    ArrayList<ItemListEspecial> mData =new ArrayList<>();
    ArrayList<FacturasItemList> factura;
    Button carrito;
    Button btnvercarro;
    private View.OnClickListener itemlistener;


    private FriosViewModel friosViewModel;
    private FragmentFriosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_frios,container,false);
        recyclerViewFrios=view.findViewById(R.id.recyclerViewFrios);
        mData=new ArrayList<>();
        cargarLista();
        friosViewModel =
                new ViewModelProvider(this).get(FriosViewModel.class);

        binding = FragmentFriosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewFrios = binding.recyclerViewFrios;
        adapterEspecial = new AdapterEspecial(mData,getContext(),factura,root,btnvercarro,carrito,itemlistener);
        adapterEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
                Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewFrios.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewFrios.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewFrios.setLayoutManager(linearLayoutManager);


        return root;
    }

    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Jugos naturales en agua o leche", "", R.drawable.jugos,"3500"));
        mData.add(new ItemListEspecial("Helados", "", R.drawable.helados,"3000"));
        mData.add(new ItemListEspecial("Postres", " ", R.drawable.postres,"3000"));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}