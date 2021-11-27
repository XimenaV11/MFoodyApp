package com.ximena.mfoodyapp.ui.principios;

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
import com.ximena.mfoodyapp.databinding.FragmentPrincipiosBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
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
        adapterEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
                Toast.makeText(getActivity(), "SELECCION "+mData.get(recyclerViewPrincipios.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
               // Intent intent=new Intent(getContext(),DescripcionFragment.class);
                //startActivity(intent);
            }
        });
        recyclerViewPrincipios.setAdapter(adapterEspecial);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewPrincipios.setLayoutManager(linearLayoutManager);


        return root;
    }
    //public void moveToDescription(ItemListEspecial item){
      //Intent intent=new Intent(getContext(), DescripcionFragment.class);
        //intent.putExtra("ItemListEspecial",item);
        //startActivity(intent);
    //}
    public void cargarLista(){
        mData=new ArrayList<>();
        mData.add(new ItemListEspecial("Frijoles", "Frijoles, con arroz,ensalada,patacon", R.drawable.frijoles,"4000"));
        mData.add(new ItemListEspecial("Lentejas", "Lentejas,Maduras de platano,ensalada,arroz", R.drawable.lentejas,"4000"));
        mData.add(new ItemListEspecial("Spaguetti", "Spaguetti con salsas,arroz,papas a la francesa ", R.drawable.spaguetti,"4000"));
        mData.add(new ItemListEspecial("Mixto de verduras", "Mixto de verduras,papas a la francesa,arroz", R.drawable.verduras,"4000"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}