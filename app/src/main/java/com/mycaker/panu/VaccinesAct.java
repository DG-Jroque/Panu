package com.mycaker.panu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VaccinesAct extends AppCompatActivity {

    ManagerBD db;
    ArrayList<Vaccine> Vaccines= new ArrayList();
    ArrayList<TableRow> Rows= new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccines);
        int id=getIntent().getIntExtra("id",0);
        TableLayout tl= (TableLayout) findViewById(R.id.tablelayoutvaccine);
        db= new ManagerBD(this, "panu", null, 1);
        try {
            Vaccines = db.showvacc(id);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al cargar vacunas", Toast.LENGTH_LONG).show();
        }
        for (Vaccine v : Vaccines) {

        }
    }
}
