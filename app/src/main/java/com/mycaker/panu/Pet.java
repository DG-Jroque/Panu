package com.mycaker.panu;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;


/**
 * Created by Carlos on 20/05/2017.
 */

public class Pet implements Serializable{

    private int age, weigth, id;
    private String name, birthDay   //FORMAT "YYYY-MM-DD"
            , breed, color, hair, imagepath ;
    private ArrayList<String> vaccines, diseases;

    public Pet(){

    }

    public Pet(int weigth, String name, String birthDay, String breed, String color, String hair ){
        this.weigth= weigth;
        this.name= name;
        this.birthDay= birthDay;//FORMAT "YYYY-MM-DD"
        this.breed=breed;
        this.color=color;
        this.hair=hair;
        this.imagepath=imagepath;
        vaccines= new ArrayList<>();
        calculateBirthDay();
    }

    public void calculateBirthDay(){
        String [] BD= this.birthDay.split("-");
        String []date = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split("-");
        int BirthMonth= parseInt(BD[1]);
        int currentMonth= parseInt(date[1]);
        if( BirthMonth >= currentMonth)     //quiere decir que no ha cumplido año en el año actual
        {
            this.age = parseInt(BD[0])-parseInt(date[0])-1;
        }
        else
        {
            int Day= parseInt(BD[2]);
            int currentDay= parseInt(date[2]);
            if(Day>=currentDay)
            {
                this.age = parseInt(BD[0])-parseInt(date[0])-1;
            }
            else
            {
                this.age = parseInt(BD[0])-parseInt(date[0]);
            }
        }

    }


    public int getWeigth() {
        return weigth;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }
    public  String getImagepath(){ return  imagepath;}
    public  void Setimagepath(){this.imagepath=imagepath;}
    public ArrayList<String> getVaccines() {
        return vaccines;
    }

    public void setVaccines(ArrayList<String> vaccines) {
        this.vaccines = vaccines;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<String> diseases) {
        this.diseases = diseases;
    }




}

