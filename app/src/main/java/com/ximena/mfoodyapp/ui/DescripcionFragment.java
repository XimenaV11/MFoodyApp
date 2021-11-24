package com.ximena.mfoodyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.databinding.FragmentDescripcionBinding;
import com.ximena.mfoodyapp.databinding.FragmentPerfilBinding;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;
import com.ximena.mfoodyapp.ui.perfil.PerfilViewModel;

public class DescripcionFragment extends AppCompatActivity {
    TextView titulo_titulo;
    TextView titulo_descripcion;
    //private PerfilViewModel perfilViewModel;
    private FragmentDescripcionBinding binding;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_descripcion);

        ItemListEspecial element=(ItemListEspecial) getIntent().getSerializableExtra("ItemListEspecial");
        titulo_titulo=findViewById(R.id.titulo_titulo);
        titulo_descripcion=findViewById(R.id.text_descripcion);
        titulo_titulo.setText(element.getNombre());
        titulo_descripcion.setText(element.getDescripcion());



    }

}
