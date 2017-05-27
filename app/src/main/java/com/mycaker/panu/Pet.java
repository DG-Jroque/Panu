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

    ArrayList<Vaccines> vaccines;
    ArrayList<Medical> medical;
    ArrayList<Deworming> deworming;


    private int age;
    private int weigth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private String birthDay;   //FORMAT "YYYY-MM-DD
    private String breed;
    private String color;
    private String hair;
    private String imagepath;
    private String specie;

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String sex ;
    public Pet(){

    }

    public Pet(int weigth, String name, String birthDay, String breed, String color, String hair, String sex, String specie,
               String imagepath){
        this.weigth= weigth;
        this.name= name;
        this.birthDay= birthDay;//FORMAT "YYYY-MM-DD"
        this.breed=breed;
        this.color=color;
        this.hair=hair;
        this.imagepath=imagepath;
        vaccines= new ArrayList<>();
        medical = new ArrayList<>();
        deworming = new ArrayList<>();
        this.sex=sex;
        this.specie=specie;
        calculateBirthDay();
    }

    public ArrayList<Vaccines> getVaccines() {
        return vaccines;
    }

    public void setVaccines(ArrayList<Vaccines> vaccines) {
        this.vaccines = vaccines;
    }

    public ArrayList<Medical> getMedical() {
        return medical;
    }

    public void setMedical(ArrayList<Medical> medical) {
        this.medical = medical;
    }

    public ArrayList<Deworming> getDeworming() {
        return deworming;
    }

    public void setDeworming(ArrayList<Deworming> deworming) {
        this.deworming = deworming;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
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






}

