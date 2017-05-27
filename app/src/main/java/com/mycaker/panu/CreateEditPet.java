package com.mycaker.panu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateEditPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_pet);


        Integer id= getIntent().getIntExtra("id", -1);
        if(id>=0){

        }
        else{
            //Si se mandó una mascota desde la actividad anterior

        }
    }
}
