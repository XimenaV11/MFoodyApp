package com.ximena.mfoodyapp.ui.especial;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ximena.mfoodyapp.R;

import java.util.ArrayList;

public class AdapterEspecial extends RecyclerView.Adapter<AdapterEspecial.ViewHolderEspecial>implements View.OnClickListener {
    private  ArrayList <ItemListEspecial> mData;

    private Context context;
    private  View root;
    //public ItemListener itemListener;
    private View.OnClickListener itemlistener;
    //private AdapterEspecial.OnItemClickListener itemListener;

    public AdapterEspecial(Context context,ArrayList<ItemListEspecial> mData,View root) {
        this.context=context;
        this.mData=mData;
        this.root=root;


        //this.mInflater=LayoutInflater.from(context);
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
    public void onBindViewHolder(final AdapterEspecial.ViewHolderEspecial holder,final int position) {
        holder.binData(mData.get(position));



    }



    public void setmData(ArrayList <ItemListEspecial> mData) {
        this.mData =mData;
    }


    public static class ViewHolderEspecial extends RecyclerView.ViewHolder {
        private ImageView Imgn;
        private TextView Titulo;
        private TextView Descripcion;
        public ConstraintLayout mainLayout;
        private OnItemClickListener itemListener;

        public ViewHolderEspecial(@NonNull View itemView) {
            super(itemView);
            Imgn = itemView.findViewById(R.id.imgItem);
            Titulo = itemView.findViewById(R.id.txtTitulo);
            Descripcion = itemView.findViewById(R.id.txtDescripcion);
            mainLayout = itemView.findViewById(R.id.containerEspecial);

        }

        void binData(final ItemListEspecial item) {
            Imgn.setImageResource(item.getImagen());
            Titulo.setText(item.getNombre());
            Descripcion.setText(item.getDescripcion());



        }

    }
}
