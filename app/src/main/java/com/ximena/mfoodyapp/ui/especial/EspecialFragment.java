package com.ximena.mfoodyapp.ui.especial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentEspecialBinding;


public class EspecialFragment extends Fragment {
    private RecyclerView recyclerViewEspecial;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial>mData =new ArrayList<>();
    private EspecialViewModel especialViewModel;
    private FragmentEspecialBinding binding;
    private LayoutInflater mInflater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_especial,container,false);
        recyclerViewEspecial=view.findViewById(R.id.recyclerViewEsp);
        mData=new ArrayList<>();
        cargarLista();


        especialViewModel =
                new ViewModelProvider(this).get(EspecialViewModel.class);

        binding = FragmentEspecialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewEspecial = binding.recyclerViewEsp;
        adapterEspecial = new AdapterEspecial(getContext(),mData,root);
        recyclerViewEspecial.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewEspecial.setLayoutManager(linearLayoutManager);


        return root;

    }
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Arroz con pollo", "arroz con pollo,papas a la francesa, ensalada y limonada.", R.drawable.aconpollo));
        mData.add(new ItemListEspecial("Arroz paisa ", "arroz paisa, papas a la francesa,patacón, limonada", R.drawable.apaisa));
        mData.add(new ItemListEspecial("Sanchocho de gallina Criolla", "Sancocho de gallina criolla, presa de pollo asada o sudada,ensalada,jugo de maracuyá.", R.drawable.sancocho_de_gallina));
        mData.add(new ItemListEspecial("Bandeja Paisa", "Bandeja de paisa con frijoles,chorizo,huevo frito, tocino asado,arepa,arroz,limonada.", R.drawable.paisa));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}