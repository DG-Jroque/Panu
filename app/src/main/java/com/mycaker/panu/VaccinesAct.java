package com.mycaker.panu;

import android.content.Intent;
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

        //Pet p= (Pet)getIntent().getSerializableExtra("id");
        TableLayout tl= (TableLayout) findViewById(R.id.tablelayoutvaccine);
        db= new ManagerBD(this, "panu", null, 1);
        final int id = getIntent().getIntExtra("id",1);
        try {
            Vaccines = db.showvacc(id);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error al cargar vacunas", Toast.LENGTH_LONG).show();
        }
        for (Vaccine v : Vaccines) {
            TableRow tr=new TableRow(null);
            TextView tx= new TextView(null);
            tx.setText(v.getName());
            TextView tx2= new TextView(null);
            tx2.setText(v.getDiluent());
            TextView tx3= new TextView(null);
            tx3.setText(v.getDate());
            tr.addView(tx);
            tr.addView(tx2);
            tr.addView(tx3);
            tl.addView(tr);
        }
    }
}
