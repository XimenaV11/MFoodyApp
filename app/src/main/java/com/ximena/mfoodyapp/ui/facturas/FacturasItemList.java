package com.ximena.mfoodyapp.ui.facturas;

import java.io.Serializable;

public class FacturasItemList implements Serializable {
    private String NombreComida;
    private String Cantidad;
    private String Preciosub;

    public String getNombreComida() {
        return NombreComida;
    }

    public void setNombreComida(String nombreComida) {
        NombreComida = nombreComida;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getPreciosub() {
        return Preciosub;
    }

    public void setPreciosub(String preciosub) {
        Preciosub = preciosub;
    }

    public FacturasItemList(String nombreComida, String cantidad, String preciosub) {
        NombreComida = nombreComida;
        Cantidad = cantidad;
        Preciosub = preciosub;

    }
}
