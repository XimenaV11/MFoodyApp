package com.ximena.mfoodyapp.persistence.entidades;


import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class User {

    @PrimaryKey
    @NonNull
    private EditText nombres;
    @NonNull
    private EditText apellidos;
    @NonNull
    private EditText correoR;

    public User(@NonNull EditText nombres, @NonNull EditText apellidos, @NonNull EditText correoR) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoR = correoR;
    }

    @NonNull
    public EditText getNombres() {
        return nombres;
    }

    public void setNombres(@NonNull EditText nombres) {
        this.nombres = nombres;
    }

    @NonNull
    public EditText getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull EditText apellidos) {
        this.apellidos = apellidos;
    }

    @NonNull
    public EditText getCorreoR() {
        return correoR;
    }

    public void setCorreoR(@NonNull EditText correoR) {
        this.correoR = correoR;
    }
}