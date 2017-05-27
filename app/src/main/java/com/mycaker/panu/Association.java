package com.mycaker.panu;

/**
 * Created by Roque on 27/05/2017.
 */

public class Association {
    public int getId_asoc() {
        return Id_asoc;
    }

    public void setId_asoc(int id_asoc) {
        Id_asoc = id_asoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private int Id_asoc;
    private String name;
    private String mail;
    private String cellphone;
    private String direccion;
    public Association(){

    }
    public Association(int Id_asoc, String name, String mail, String cellphone, String direccion){
        this.Id_asoc=Id_asoc;
        this.name=name;
        this.mail=mail;
        this.cellphone=cellphone;
        this.direccion=direccion;
    }
}
