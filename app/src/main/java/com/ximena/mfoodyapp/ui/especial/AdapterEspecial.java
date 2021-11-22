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
import java.util.List;

public class AdapterEspecial extends RecyclerView.Adapter<AdapterEspecial.ViewHolderEspecial>implements View.OnClickListener {
    private  ArrayList <ItemListEspecial> mData;
    private  View.OnClickListener listener;
    private Context context;
    private  View root;

    public AdapterEspecial(Context context,ArrayList<ItemListEspecial> mData,View root) {
        this.context=context;
        this.mData=mData;
        this.root=root;
        //this.mInflater=LayoutInflater.from(context);
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
        return new ViewHolderEspecial(view);

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }
    @Override
    public void onBindViewHolder(@NonNull AdapterEspecial.ViewHolderEspecial holder,final int position) {
        holder.Imgn.setImageResource(mData.get(position).getImagen());
        holder.Titulo.setText(mData.get(position).getNombre());
        holder.Descripcion.setText(mData.get(position).getDescripcion());

    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }
    public void setmData(ArrayList <ItemListEspecial> mData) {
        this.mData =mData;
    }


    public static class ViewHolderEspecial extends RecyclerView.ViewHolder{
        private ImageView Imgn;
        private TextView Titulo;
        private TextView Descripcion;
        public ConstraintLayout mainLayout;

        public ViewHolderEspecial(@NonNull View itemView) {
            super(itemView);
            Imgn=itemView.findViewById(R.id.imgItem);
            Titulo=itemView.findViewById(R.id.txtTitulo);
            Descripcion=itemView.findViewById(R.id.txtDescripcion);
            mainLayout = itemView.findViewById(R.id.containerEspecial);
        }
    }
}
