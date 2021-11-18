package com.ximena.mfoodyapp.persistence.entidades;


import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class User {

    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    private String nombres;
    @NonNull
    private String apellidos;
    @NonNull
    private String correoR;

    public User(@NonNull String id,@NonNull String nombres, @NonNull String apellidos, @NonNull String correoR) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correoR = correoR;
    }

    @NonNull
    public String getNombres() {
        return nombres;
    }

    public void setNombres(@NonNull String nombres) {
        this.nombres = nombres;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    @NonNull
    public String getCorreoR() {
        return correoR;
    }

    public void setCorreoR(@NonNull String correoR) {
        this.correoR = correoR;
    }
}