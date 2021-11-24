package com.ximena.mfoodyapp.ui.facturas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ximena.mfoodyapp.databinding.FragmentFacturasBinding;


public class FacturasFragment extends Fragment {
    private FacturasViewModel facturasViewModel;
    private FragmentFacturasBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        facturasViewModel =
                new ViewModelProvider(this).get(FacturasViewModel.class);

        binding = FragmentFacturasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
