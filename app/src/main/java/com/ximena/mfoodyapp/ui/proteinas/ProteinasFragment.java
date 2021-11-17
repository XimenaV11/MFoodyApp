package com.ximena.mfoodyapp.ui.proteinas;

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


public class ProteinasFragment extends Fragment {

    private ProteinasViewModel proteinasViewModel;
    private FragmentEspecialBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        proteinasViewModel =
                new ViewModelProvider(this).get(ProteinasViewModel.class);

        binding = FragmentEspecialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEspecial;
        proteinasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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