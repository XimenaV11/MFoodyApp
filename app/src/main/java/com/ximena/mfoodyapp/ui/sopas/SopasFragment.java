package com.ximena.mfoodyapp.ui.sopas;

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
import com.ximena.mfoodyapp.databinding.FragmentSopasBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.EspecialViewModel;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;
import com.ximena.mfoodyapp.ui.facturas.FacturasItemList;

import java.util.ArrayList;


public class SopasFragment extends Fragment {
    private RecyclerView recyclerViewSopas;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial> mData =new ArrayList<>();
    private EspecialViewModel especialViewModel;

    private SopasViewModel sopasViewModel;
    private FragmentSopasBinding binding;
    ArrayList<FacturasItemList> factura;
    Button carrito;
    Button btnvercarro;
    private View.OnClickListener itemlistener;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_sopas,container,false);
        recyclerViewSopas=view.findViewById(R.id.recyclerViewSopas);
        mData=new ArrayList<>();
        cargarLista();
        sopasViewModel =
                new ViewModelProvider(this).get(SopasViewModel.class);

        binding = FragmentSopasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewSopas = binding.recyclerViewSopas;
        adapterEspecial = new AdapterEspecial(mData,getContext(),factura,root,carrito,btnvercarro,itemlistener);
        adapterEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
                Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewSopas.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewSopas.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewSopas.setLayoutManager(linearLayoutManager);


        return root;
    }

    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Sopa de verduras", "Sopa de verduras con pollo", R.drawable.sopa_de_verduras,"3000"));
        mData.add(new ItemListEspecial("Sopa de pastas ", "Sopa de pastas con pollo", R.drawable.sopa_de_pasta,"3000"));
        mData.add(new ItemListEspecial("Sopa de mondongo", "Sopa de mondongo con pollo.", R.drawable.sopa_de_mondongo,"3000"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}