package com.mycaker.panu;

import android.graphics.drawable.Drawable;

/**
 * Created by Roque on 27/05/2017.
 */

public class PetsAvailable {
    private int id_masc,asoc_id,peso;
    private String Nombre,especie,raza,sexo,color,pelo,fecha_nac,caracteristicas;
    private Drawable foto;

    public PetsAvailable(int id_masc, int asoc_id, int peso, String nombre, String especie, String raza, String sexo, String color, String pelo, String fecha_nac, String caracteristicas, Drawable foto) {
        super();
        this.id_masc = id_masc;
        this.asoc_id = asoc_id;
        this.peso = peso;
        Nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.sexo = sexo;
        this.color = color;
        this.pelo = pelo;
        this.fecha_nac = fecha_nac;
        this.caracteristicas = caracteristicas;
        this.foto = foto;
    }
    public PetsAvailable() {
        super();
    }



    public int getId_masc() {
        return id_masc;
    }

    public void setId_masc(int id_masc) {
        this.id_masc = id_masc;
    }

    public int getAsoc_id() {
        return asoc_id;
    }

    public void setAsoc_id(int asoc_id) {
        this.asoc_id = asoc_id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPelo() {
        return pelo;
    }

    public void setPelo(String pelo) {
        this.pelo = pelo;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }
}
