package com.ximena.mfoodyapp.ui.frios;

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
import com.ximena.mfoodyapp.databinding.FragmentFriosBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.EspecialViewModel;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;

import java.util.ArrayList;


public class FriosFragment extends Fragment {
    private RecyclerView recyclerViewFrios;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial> mData =new ArrayList<>();

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
        adapterEspecial = new AdapterEspecial(getContext(),mData,root);
        recyclerViewFrios.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewFrios.setLayoutManager(linearLayoutManager);


        return root;
    }
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Jugos naturales en agua o leche", "", R.drawable.jugos));
        mData.add(new ItemListEspecial("Helados", "", R.drawable.helados));
        mData.add(new ItemListEspecial("Postres", " ", R.drawable.postres));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}