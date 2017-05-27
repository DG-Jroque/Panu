package com.mycaker.panu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by keam on 26/05/17.
 */

public class ManagerBD extends SQLiteOpenHelper {

    public ManagerBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ctp = "CREATE TABLE PETS (id INTEGER PRIMARY KEY ASC, name TEXT, birthday TEXT, breed TEXT, color TEXT, hair TEXT, weigth TEXT, sex TEXT, spercie TEXT;)";
        db.execSQL(ctp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inpet(Pet p) throws Exception{
            SQLiteDatabase db = this.getWritableDatabase();
            String index = "SELECT id FROM PETS ORDER BY id ASC LIMIT 1;";
            id = db.execSQL(index);
            String ip = "INSERT INTO PETS VALUES ("+id+", "+p.getName()+", "+p.getBirthDay()+", "+p.getBreed()+", "+p.getColor()+", "+p.getHair()+", "+p.getWeigth()+", "+p.getSex()+")";
    }
    public void edpet(){

    }
    public void delpet(){

    }
    public void invac(){

    }
    public void delvac(){

    }
    public void indes(){

    }
    public void deldes(){

    }
    public void indew(){

    }
    public void deldew(){

    }
}
