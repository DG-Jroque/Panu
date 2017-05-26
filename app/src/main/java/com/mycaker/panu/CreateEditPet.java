package com.mycaker.panu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateEditPet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_pet);
        Pet pet=(Pet) getIntent().getSerializableExtra("pet");
        boolean edit= getIntent().getBooleanExtra("edit", false);
        if(edit){

        }

    }
}
