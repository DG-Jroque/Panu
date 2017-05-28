package com.mycaker.panu;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class petCarnet extends AppCompatActivity {

    ManagerBD db;
    Pet p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_carnet);
        final int id = getIntent().getIntExtra("id", 0);
        db = new ManagerBD(this, "panu", null, 1);
        try {
            p = db.showpet(id);
            //Toast.makeText(getApplicationContext(), p.getId()+"", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al cargar mascota", Toast.LENGTH_LONG).show();
        }

        ImageView ivp = (ImageView) findViewById(R.id.imageView8);
        ivp.setImageBitmap(BitmapFactory.decodeFile(p.getImagepath()));

        EditText etp = (EditText) findViewById((R.id.editText));
        etp.setText("Nombre: " + p.getName() +
                "\t Especie: " + p.getSpecie() +
                "\n Raza: " + p.getBreed() +
                "\t Sexo: " + p.getSex() +
                "\n Tamaño: " + p.getSize() +
                "\t Pelo: " + p.getHair() +
                "\n Color: " + p.getColor() +
                "\t Fecha de nacimiento: " + p.getBirthDay() +
                "\n Peso: " + p.getWeigth());

        /*ImageButton epb = (ImageButton) findViewById(R.id.editpetbutton);
        epb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(petCarnet.this, CreateEditPet.class );
                i.putExtra("id", p.getId());
                startActivity(i);
                Toast.makeText(petCarnet.this, "Yes", Toast.LENGTH_LONG).show();
            }
        });*/
        ImageButton be = (ImageButton) findViewById(R.id.buttonedit);
        be.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a =new Intent(petCarnet.this, CreateEditPet.class);
                //a.putExtra("id", 1);
                startActivity(a);
            }
        });
        ImageButton bv = (ImageButton) findViewById(R.id.buttonvac);
        bv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), VaccinesAct.class);
                //b.putExtra("id",1);
                startActivity(b);
            }
        });
        ImageButton bd = (ImageButton) findViewById(R.id.buttondw);
        bd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent c =new Intent(getApplicationContext(), Deworming.class);
                c.putExtra("id",1);
                startActivity(c);
            }
        });

    }
}
