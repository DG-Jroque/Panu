package com.mycaker.panu;

/**
 * Created by Carlos on 27/05/2017.
 */

public class Medical {
    String disease, date;
    int id, petId;

    Medical(String desease, String date, int id, int petId){
        this.disease =desease;
        this.date=date;
        this.id=id;
        this.petId=petId;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
