package com.ximena.mfoodyapp.ui.principios;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentEspecialBinding;
import com.ximena.mfoodyapp.ui.especial.EspecialViewModel;


public class PrincipiosFragment extends Fragment {

    private PrincipiosViewModel principiosViewModel;
    private FragmentEspecialBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        principiosViewModel =
                new ViewModelProvider(this).get(PrincipiosViewModel.class);

        binding = FragmentEspecialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEspecial;
        principiosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}