package com.ximena.mfoodyapp.ui.especial;

import android.content.Context;
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

import java.util.ArrayList;


import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentEspecialBinding;


public class EspecialFragment extends Fragment {
    private RecyclerView recyclerViewEspecial;
    private AdapterEspecial adapterEspecial;
    private ArrayList<ItemListEspecial>mData =new ArrayList<>();
    private EspecialViewModel especialViewModel;
    private FragmentEspecialBinding binding;
    private LayoutInflater mInflater;
    private Context context;

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
        AdapterEspecial adapterEspecial = new AdapterEspecial(getContext(), mData, root);
        adapterEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewEspecial.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();


            }


            //intent.putExtra("ItemListEspecial",item);
                //intent.putExtra("nombre",item.getNombre());
                //intent.putExtra("descripcion",item.getDescripcion());
                //intent.putExtra("imagen",item.getImagen());
                //intent.putExtra("precio",item.getPrecio());
                //itemView.getContext().startActivity(intent);
                //context.startActivity(intent);
                //ntent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
                //Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewEspecial.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
                //+ mData.get(recyclerViewEspecial.getChildAdapterPosition(view)).getNombre()

        });

        recyclerViewEspecial.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewEspecial.setLayoutManager(linearLayoutManager);


        return root;

    }
    //public void moveToDescription(ItemListEspecial item){
      //  Intent intent=new Intent(getContext(),DescripcionFragment.class);
      //  intent.putExtra("ItemListEspecial",item);
        //startActivity(intent);
    //}
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Arroz con pollo", "arroz con pollo,papas a la francesa, ensalada y limonada.", R.drawable.aconpollo,"12.000"));
        mData.add(new ItemListEspecial("Arroz paisa ", "arroz paisa, papas a la francesa,patacón, limonada", R.drawable.apaisa,"12.000"));
        mData.add(new ItemListEspecial("Sanchocho de gallina Criolla", "Sancocho de gallina criolla, presa de pollo asada o sudada,ensalada,limonada.", R.drawable.sancocho_de_gallina,"15.000"));
        mData.add(new ItemListEspecial("Bandeja Paisa", "Bandeja de paisa con frijoles,chorizo,huevo frito, tocino asado,arepa,arroz,limonada.", R.drawable.paisa,"15.000"));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}