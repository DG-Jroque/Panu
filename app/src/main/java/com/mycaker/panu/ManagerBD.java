package com.mycaker.panu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String ctp = "CREATE TABLE PETS (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, birthday TEXT, breed TEXT, color TEXT, hair TEXT, weigth TEXT, sex TEXT, specie TEXT);";
        db.execSQL(ctp);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inpet(Pet p) throws Exception{
            SQLiteDatabase db = this.getWritableDatabase();
            /*String index = "SELECT id FROM PETS ORDER BY id ASC LIMIT 1;";
            Cursor cursor = db.rawQuery(index, null);
            while(cursor.moveToNext()) {
                cursor.getString(0);
                cursor.getInt(1)
            }*/
            String ip = "INSERT INTO PETS VALUES ("+p.getName()+", "+p.getBirthDay()+", "+p.getBreed()+", "+p.getColor()+", "+p.getHair()+", "+p.getWeigth()+", "+p.getSex()+", "+p.getSpecie()+");";
    }
    public void edpet(Pet p){
        SQLiteDatabase db = this.getWritableDatabase();
        String ip = "UPDATE PETS SET name = "+p.getName()+", birthday = "+p.getBirthDay()+", breed = "+p.getBreed()+", color = "+p.getColor()+", hair = "+p.getHair()+", weigth = "+p.getWeigth()+", sex = "+p.getSex()+", specie = "+p.getSpecie()+"WHERE id = "+p.getId()+";";

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
