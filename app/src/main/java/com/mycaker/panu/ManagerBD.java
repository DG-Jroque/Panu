package com.mycaker.panu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by keam on 26/05/17.
 */

public class ManagerBD extends SQLiteOpenHelper {

    public ManagerBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ctp = "CREATE TABLE PETS (id_pet INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, birthday TEXT, breed TEXT, color TEXT, hair TEXT, weigth TEXT, sex TEXT, specie TEXT, picture TEXT, size TEXT);";
        String ctv = "CREATE TABLE VACCINES (id_vacc INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date TEXT, diluent TEXT, petid INTEGER);";
        String ctm = "CREATE TABLE MEDICAL (id_med INTEGER PRIMARY KEY AUTOINCREMENT, disease TEXT, date TEXT, petid INTEGER);";
        String ctw = "CREATE TABLE DEWORMING (id_dew INTEGER PRIMARY KEY AUTOINCREMENT, product TEXT, date TEXT, petid INTEGER);";
        db.execSQL(ctp);
        db.execSQL(ctv);
        db.execSQL(ctm);
        db.execSQL(ctw);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    //Section of querys for pet

    public Pet showpet(int id) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String sp = "SELECT * FROM PETS WHERE id_pet = " + id + ";";
        Cursor cursor = db.rawQuery(sp, null);
        cursor.moveToNext();
        //agregar el atributo size al crear el objeto Pet
        Pet pe = new Pet(cursor.getInt(6),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10));
        return pe;
    }

    public String showpetstring(int id) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String sp = "SELECT * FROM PETS WHERE id_pet = " + id + ";";
        Cursor cursor = db.rawQuery(sp, null);
        cursor.moveToNext();
        //agregar el atributo size al crear el objeto Pet
        String pe = " "+cursor.getInt(6)+cursor.getString(1)+cursor.getString(2)+cursor.getString(3);
        return pe;
    }

    public int countpet() throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String cp = "SELECT count(id_pet) FROM PETS;";
        Cursor cursor = db.rawQuery(cp, null);
        cursor.moveToNext();
        return cursor.getInt(0);
    }

    public void inpet(Pet p) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String ip = "INSERT INTO PETS VALUES ( " + null +
                ", '" + p.getName() +
                "', '" + p.getBirthDay() +
                "', '" + p.getBreed() +
                "', '" + p.getColor() +
                "', '" + p.getHair() +
                "', " + p.getWeigth() +
                ", '" + p.getSex() +
                "', '" + p.getSpecie() +
                "', '" + p.getImagepath() +
                "', '" + p.getSize() + "');";
        db.execSQL(ip);
    }

    public void edpet(Pet p) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String ep = "UPDATE PETS SET name = '" + p.getName() +
                "', birthday = '" + p.getBirthDay() +
                "', breed = '" + p.getBreed() +
                "', color = '" + p.getColor() +
                "', hair = '" + p.getHair() +
                "', weigth = " + p.getWeigth() +
                ", sex = '" + p.getSex() +
                "', specie = '" + p.getSpecie() +
                "', picture = '" + p.getImagepath() +
                "', size = '" + p.getSize() +
                "' WHERE id_pet = " + p.getId() + ";";
        db.execSQL(ep);
    }

    public void delpet(int id) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String dp = "DELETE FROM PETS WHERE id_pet = " + id + ";";
        db.execSQL(dp);
    }

    //Section of querys for vaccine

    public ArrayList<Vaccine> showvacc(int id) throws Exception{
        ArrayList<Vaccine> vaccines = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sv = "SELECT * FROM VACCINES WHERE id_pet = " + id + ";";
        Cursor cursor = db.rawQuery(sv, null);
        while(cursor.moveToNext()) {
            Vaccine vaux = new Vaccine(cursor.getString(2),cursor.getString(1),cursor.getString(3),cursor.getInt(0),cursor.getInt(4));
            vaccines.add(vaux);
        }
        return vaccines;
    }

    public void invac(Vaccine v) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String iv = "INSERT INTO VACCINES VALUES (" + null + ", '" + v.getName() +
                "', '" + v.getDate() +
                "', '" + v.getDiluent() +
                "', " + v.getPetId() + ");";
        db.execSQL(iv);
    }

    public void delvac(int id) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String dv = "DELETE FROM VACCINES WHERE id_vacc = " + id + ";";
        db.execSQL(dv);
    }

    //Section of querys for medical

    public ArrayList<Medical> showmed(int id) throws Exception{
        ArrayList<Medical> medicals = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sm = "SELECT * FROM MEDICAL WHERE id_pet = " + id + ";";
        Cursor cursor = db.rawQuery(sm, null);
        while(cursor.moveToNext()) {
            Medical maux = new Medical(cursor.getString(1),cursor.getString(2),cursor.getInt(0),cursor.getInt(3));
            medicals.add(maux);
        }
        return medicals;
    }

    public void inmed(Medical m) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String im = "INSERT INTO VACCINES VALUES ("+null+", '" + m.getDisease() +
                "', '" + m.getDate() +
                "', " + m.getPetId() + ");";
        db.execSQL(im);
    }

    public void delmed(int id) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String dm = "DELETE FROM MEDICAL WHERE id_med = " + id + ";";
        db.execSQL(dm);
    }

    //Section of querys for deworming

    public ArrayList<Deworming> showdew(int id) throws Exception {
        ArrayList<Deworming> dewormings = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String sd = "SELECT * FROM VACCINES WHERE id_pet = " + id + ";";
        Cursor cursor = db.rawQuery(sd, null);
        while (cursor.moveToNext()) {
            Deworming daux = new Deworming(cursor.getString(2), cursor.getString(1), cursor.getInt(0), cursor.getInt(3));
            dewormings.add(daux);
        }
        return dewormings;
    }

    public void indew(Deworming d) throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String id = "INSERT INTO DEWORMING VALUES ("+null+", '" + d.getProduct() +
                "', '" + d.getDate() +
                "', " + d.getPetId() + ");";
        db.execSQL(id);
    }

    public void deldew() throws Exception{
        SQLiteDatabase db = this.getWritableDatabase();
        String dd = "DELETE FROM DEWORMING WHERE id_dew = " + id + ";";
        db.execSQL(dd);
    }
}
