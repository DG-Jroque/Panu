package com.mycaker.panu;

/**
 * Created by Carlos on 27/05/2017.
 */

public class Vaccine {
    private String date, name, diluent;
    private int id, petId;

    Vaccine(String date, String name, String diluent, int id, int petId){
        this.date=date;
        this.name=name;
        this.diluent=diluent;
        this.id=id;
        this.petId=petId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiluent() {
        return diluent;
    }

    public void setDiluent(String diluent) {
        this.diluent = diluent;
    }
}
