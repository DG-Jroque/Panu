package com.mycaker.panu;

/**
 * Created by Roque on 27/05/2017.
 */

public class Association {
    private int id_asoc,numero;
    private String correo,password,calle,colonia,ciudad,estado,telefono;

    public Association(int id_asoc, int numero, String correo, String password, String calle, String colonia, String ciudad, String estado, String telefono) {
        this.id_asoc = id_asoc;
        this.numero = numero;
        this.correo = correo;
        this.password = password;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.telefono = telefono;
    }

    public int getId_asoc() {
        return id_asoc;
    }

    public void setId_asoc(int id_asoc) {
        this.id_asoc = id_asoc;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
