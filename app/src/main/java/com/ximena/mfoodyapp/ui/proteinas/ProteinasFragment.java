package com.ximena.mfoodyapp.ui.proteinas;

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
import android.widget.Toast;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentProteinasBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;

import java.util.ArrayList;


public class ProteinasFragment extends Fragment {
    private RecyclerView recyclerViewProteinas;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial> mData =new ArrayList<>();

    private ProteinasViewModel proteinasViewModel;
    private FragmentProteinasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_proteinas,container,false);
        recyclerViewProteinas=view.findViewById(R.id.recyclerViewProteinas);
        mData=new ArrayList<>();
        cargarLista();
        proteinasViewModel =
                new ViewModelProvider(this).get(ProteinasViewModel.class);

        binding = FragmentProteinasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewProteinas = binding.recyclerViewProteinas;
        adapterEspecial = new AdapterEspecial(getContext(),mData,root);
        adapterEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
                Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewProteinas.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewProteinas.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewProteinas.setLayoutManager(linearLayoutManager);


        return root;
    }

    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Carne asada", "", R.drawable.carne_asada,"3000"));
        mData.add(new ItemListEspecial("Carne Sudada", "", R.drawable.carne_sudada,"3000"));
        mData.add(new ItemListEspecial("Pollo asado", "", R.drawable.pollo_asado,"4000"));
        mData.add(new ItemListEspecial("Pechuga a la plancha", ".", R.drawable.pechuga_plancha,"4000"));
        mData.add(new ItemListEspecial("Mojarra frita", ".", R.drawable.mojarra_frita,"5000"));
        mData.add(new ItemListEspecial("Bagre en salsa", ".", R.drawable.bagre,"5000"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}