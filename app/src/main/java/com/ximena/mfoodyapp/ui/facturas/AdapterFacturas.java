package com.ximena.mfoodyapp.ui.facturas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.ui.especial.AdapterEspecial;
import com.ximena.mfoodyapp.ui.especial.ItemListEspecial;

import java.util.ArrayList;

public class AdapterFacturas extends RecyclerView.Adapter<AdapterFacturas.ViewHolderFacturas>implements View.OnClickListener {
    ArrayList<FacturasItemList> factura;
    private Context context;
    private View root;

    //public ItemListener itemListener;
    //private View.OnClickListener itemlistener;

    public AdapterFacturas(ArrayList<FacturasItemList> factura, Context context, View root) {
        this.factura = factura;
        this.context = context;
        this.root = root;

    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public AdapterFacturas.ViewHolderFacturas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_compras_view, parent, false);
        view.setOnClickListener(this);
        return new AdapterFacturas.ViewHolderFacturas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFacturas.ViewHolderFacturas holder, int position) {
        holder.binData(factura.get(position));
    }

    @Override
    public int getItemCount() {
        return factura.size();
    }

    public static class ViewHolderFacturas extends RecyclerView.ViewHolder {
         TextView Titulo2;
         TextView Cantidad;
         TextView Precio2;
        public ConstraintLayout mainLayout;

        public void setTitulo2(TextView titulo2) {
            Titulo2 = titulo2;
        }

        private Context context;
        public Button carrito;

        public ViewHolderFacturas(@NonNull View itemView) {
            super(itemView);
            Titulo2 =(TextView)itemView.findViewById(R.id.txtTitulo2);
            Cantidad = (TextView) itemView.findViewById(R.id.textcantidad2);
            mainLayout = itemView.findViewById(R.id.containerCompras);
            Precio2 =(TextView) itemView.findViewById(R.id.textPrecio2);
        }

        void binData(final FacturasItemList item2) {
            Cantidad.setText((CharSequence) item2.getCantidad());
            Titulo2.setText((CharSequence) item2.getNombreComida());
            Precio2.setText((CharSequence) item2.getPreciosub());
            context = itemView.getContext();
        }
    }
}
