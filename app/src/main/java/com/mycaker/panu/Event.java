package com.mycaker.panu;

/**
 * Created by Roque on 27/05/2017.
 */

public class Event {
   private int id_even,asoc_id,numero;
    private String nombre,correo,password,calle, colonia,ciudad,estado,telefono;

    public Event(int id_even, int asoc_id, int numero, String nombre, String correo, String password, String calle, String colnia, String ciudad, String estado, String telefono) {
        this.id_even = id_even;
        this.asoc_id = asoc_id;
        this.numero = numero;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.calle = calle;
        this.colonia = colnia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
    }

    public int getId_even() {
        return id_even;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    public int getAsoc_id() {
        return asoc_id;
    }

    public void setAsoc_id(int asoc_id) {
        this.asoc_id = asoc_id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
