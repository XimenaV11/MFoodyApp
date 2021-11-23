package com.ximena.mfoodyapp.ui.principios;

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

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentEspecialBinding;
import com.ximena.mfoodyapp.databinding.FragmentPrincipiosBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.EspecialViewModel;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;

import java.util.ArrayList;


public class PrincipiosFragment extends Fragment {
    private RecyclerView recyclerViewPrincipios;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial> mData =new ArrayList<>();


    private PrincipiosViewModel principiosViewModel;
    private FragmentPrincipiosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_principios,container,false);
        recyclerViewPrincipios=view.findViewById(R.id.recyclerViewPrincipios);
        mData=new ArrayList<>();
        cargarLista();
        principiosViewModel =
                new ViewModelProvider(this).get(PrincipiosViewModel.class);

        binding = FragmentPrincipiosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewPrincipios = binding.recyclerViewPrincipios;
        adapterEspecial = new AdapterEspecial(getContext(),mData,root);
        recyclerViewPrincipios.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewPrincipios.setLayoutManager(linearLayoutManager);


        return root;
    }
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Frijoles", "Frijoles,arroz,ensalada,patacon", R.drawable.frijoles));
        mData.add(new ItemListEspecial("Lentejas", "Lentejas,Maduras de platano,ensalada,arroz", R.drawable.lentejas));
        mData.add(new ItemListEspecial("Spaguetti", "Spaguetti con salsas,arroz, ", R.drawable.spaguetti));
        mData.add(new ItemListEspecial("Mixto de verduras", "Mixto de verduras,papas a la francesa,arroz", R.drawable.verduras));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}