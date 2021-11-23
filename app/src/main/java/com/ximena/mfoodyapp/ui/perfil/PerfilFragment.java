package com.ximena.mfoodyapp.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentPerfilBinding;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.perfil.PerfilViewModel;
import com.ximena.mfoodyapp.ui.principios.PrincipiosViewModel;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private PerfilViewModel perfilViewModel;
    private FragmentPerfilBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}