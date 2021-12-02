package com.ximena.mfoodyapp.ui.especial;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ximena.mfoodyapp.R;
import com.ximena.mfoodyapp.ui.facturas.FacturasFragment;
import com.ximena.mfoodyapp.ui.facturas.FacturasItemList;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterEspecial extends RecyclerView.Adapter<AdapterEspecial.ViewHolderEspecial>implements View.OnClickListener {
    public  ArrayList <ItemListEspecial> mData;
    public  ArrayList <FacturasItemList> factura;



    private Context context;
    private  View root;
    Button btnvercarro;
    Button carrito;
    //public ItemListener itemListener;
    private View.OnClickListener itemlistener;
    //private AdapterEspecial.OnItemClickListener itemListener;


    public AdapterEspecial(ArrayList<ItemListEspecial> mData, Context context,ArrayList<FacturasItemList> factura,  View root, Button btnvercarro,Button carrito, View.OnClickListener itemlistener) {
        this.mData = mData;
        this.factura = factura;
        this.context = context;
        this.root = root;
        this.carrito=carrito;
        this.btnvercarro = btnvercarro;
        this.itemlistener = itemlistener;
    }




    public interface OnItemClickListener {
        void onItemClick(ItemListEspecial item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    @NonNull
    @Override
    public ViewHolderEspecial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_lists_view,parent,false);
        view.setOnClickListener(this);
        return new ViewHolderEspecial(view);

    }
    public void setOnClickListener(View.OnClickListener itemlistener){
        this.itemlistener=itemlistener;

    }

    @Override
    public void onClick(View v) {
        if (itemlistener!=null){
            itemlistener.onClick(v);

    }}

    @Override
    public void onBindViewHolder(final AdapterEspecial.ViewHolderEspecial holder, @SuppressLint("RecyclerView") final int position) {
        holder.binData(mData.get(position));
       /* carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carrito.isSelected()==true){
                    factura.add(holder.binData(mData.get(position)));

                }else if (carrito.isSelected()==false){
                    factura.remove(holder.binData(mData.get(position)));

                }


            }
        });*/


        /*carrito.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                compras.add(mData.get(position));
                Intent intent=new Intent (context, FacturasFragment.class);
                intent.putExtra("CarroCompras", (Serializable)  compras);
                context.startActivity(intent);
            }
        });*/

    }




    public void setmData(ArrayList <ItemListEspecial> mData) {
        this.mData =mData;
    }


    public static class ViewHolderEspecial extends RecyclerView.ViewHolder {
        private ImageView Imgn;
        private TextView Titulo;
        private TextView Descripcion;
        private TextView Precio;
        ArrayList<FacturasItemList> factura;
        public ConstraintLayout mainLayout;
        private OnItemClickListener itemListener;
        private Context context;
        public Button carrito;

        public ViewHolderEspecial(@NonNull View itemView) {
            super(itemView);
            Imgn = itemView.findViewById(R.id.imgItem);
            Titulo = itemView.findViewById(R.id.txtTitulo);
            Descripcion = itemView.findViewById(R.id.txtDescripcion);
            mainLayout = itemView.findViewById(R.id.containerEspecial);
            Precio = itemView.findViewById(R.id.textPrecio);
            carrito =itemView.findViewById(R.id.buttoncarrito);


        }

            void binData(final ItemListEspecial item) {
            Imgn.setImageResource(item.getImagen());
            Titulo.setText(item.getNombre());
            Descripcion.setText(item.getDescripcion());
            Precio.setText(item.getPrecio());
            context=itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //itemListener.onItemClick(item);
                    Intent intent=new Intent(context.getApplicationContext(), com.ximena.mfoodyapp.Descripcion.class);
                    intent.putExtra("ItemListEspecial",item);
                    //intent.putExtra("nombre",item.getNombre());
                    //intent.putExtra("descripcion",item.getDescripcion());
                    //intent.putExtra("imagen",item.getImagen());
                    //intent.putExtra("precio",item.getPrecio());
                    //itemView.getContext().startActivity(intent);
                    context.startActivity(intent);/*

                    */
                }
            });



        }

    }
}
