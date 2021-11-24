package com.ximena.mfoodyapp.ui.especial;

import java.io.Serializable;

public class ItemListEspecial implements Serializable {
    private String Nombre;
    private String Descripcion;
    private int imagen;
    public ItemListEspecial(String nombre, String descripcion, int imagen) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
