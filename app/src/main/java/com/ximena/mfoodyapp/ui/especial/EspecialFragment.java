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
        mostrarDatos();


        especialViewModel =
                new ViewModelProvider(this).get(EspecialViewModel.class);

        binding = FragmentEspecialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewEspecial = binding.recyclerViewEsp;
        adapterEspecial = new AdapterEspecial(getContext(),mData,root);
        recyclerViewEspecial.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewEspecial.setLayoutManager(linearLayoutManager);

        final TextView textView = binding.textEspecial;
        especialViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Arroz con pollo", "arroz con pollo,papas a la francesa.", R.drawable.aconpollo));
        mData.add(new ItemListEspecial("Arroz paisa 4", "arroz paisa, papas a la francesa.", R.drawable.apaisa));
        mData.add(new ItemListEspecial("Sanchocho de gallina Blues", "gallina criolla.", R.drawable.ic_menu_camera));
        mData.add(new ItemListEspecial("otra comida", "otra comida de prueba.", R.drawable.ic_menu_camera));

        //AdapterEspecial adapter=new AdapterEspecial(getContext(),mData);
        //recyclerViewEspecial.setHasFixedSize(true);
        //recyclerViewEspecial.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerViewEspecial.setAdapter(adapter);
    }
    public void mostrarDatos(){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}