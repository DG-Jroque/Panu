package com.mycaker.panu;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Associations extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Association e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayList<Association> disponibles = new ArrayList<Association>();
        e1=new Association(1,23,"Panu","jose.roque@tecmor.mx","123456","Ana Gallaga","Centro","Morelia","Michoacan","4434656736");
        e2=new Association(2,12,"Clinica de Atencion Canina","catc@gob.mx","123456","Tecnologico","Santiaguito","Morelia","Michoacan","4434656736");
        disponibles.add(e1);
        disponibles.add(e2);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new AdapterAssociation(this,disponibles,R.layout.item_eandas) {
            @Override
            public void onDisplayRow(View view, int pos) {
                TextView title = (TextView) view.findViewById(R.id.category);
                TextView description = (TextView) view.findViewById(R.id.texto);
                TextView text = (TextView) view.findViewById(R.id.MainText);

                title.setText(disponibles.get(pos).getNombre());
                description.setText(disponibles.get(pos).getEstado());
                text.setText(disponibles.get(pos).getCorreo());
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_associations);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_associations);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_pets, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id){
            case R.id.Adoption:{
                Intent intent=new Intent(Associations.this,Adoption.class);
                startActivity(intent);
            }break;
            case R.id.About:{
                Intent intent=new Intent(Associations.this,About.class);
                startActivity(intent);
            }break;
            case R.id.Addpet:{
                Intent intent=new Intent(Associations.this,CreateEditPet.class);
                startActivity(intent);
            }break;
            case R.id.Associations:{
                Intent intent=new Intent(Associations.this,Associations.class);
                startActivity(intent);
            }break;
            case R.id.Events:{
                Intent intent=new Intent(Associations.this,Events.class);
                startActivity(intent);
            }break;
            case R.id.Mypets:{
                Intent intent=new Intent(Associations.this,myPets.class);
                startActivity(intent);

            }break;
            default:break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_associations);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
