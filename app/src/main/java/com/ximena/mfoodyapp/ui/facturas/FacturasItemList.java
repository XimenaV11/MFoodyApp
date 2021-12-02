package com.ximena.mfoodyapp.ui.facturas;

import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import org.w3c.dom.Text;

import java.io.Serializable;

public class FacturasItemList implements Serializable {
    public TextView NombreComida;
    public ElegantNumberButton Cantidad;
    public TextView Preciosub;

    public FacturasItemList(TextView nombreComida, ElegantNumberButton cantidad, TextView preciosub) {
        NombreComida = nombreComida;
        Cantidad = cantidad;
        Preciosub = preciosub;
    }

    public FacturasItemList(String toString) {

    }

    public TextView getNombreComida() {
        return NombreComida;
    }

    public void setNombreComida(TextView nombreComida) {
        NombreComida = nombreComida;
    }

    public ElegantNumberButton getCantidad() {
        return Cantidad;
    }

    public void setCantidad(ElegantNumberButton cantidad) {
        Cantidad = cantidad;
    }

    public TextView getPreciosub() {
        return Preciosub;
    }

    public void setPreciosub(TextView preciosub) {
        Preciosub = preciosub;
    }
}

