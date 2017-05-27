package com.mycaker.panu;

/**
 * Created by Carlos on 27/05/2017.
 */

public class Deworming {
    String date, product;
    int id,petId;

    Deworming(String date, String product, int id, int petId){
        this.date=date;
        this.product=product;
        this.id=id;
        this.petId=petId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
