package com.mycaker.panu;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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

public class Events extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    Event e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayList<Event> disponibles = new ArrayList<Event>();
        e1=new Event(1,1,5,"Croqueton","jose.roque@tecmor.mx","123456","Ana Gallaga","Centro","Morelia","Michoacan","4434656736");
        e2=new Event(2,2,12,"Campana de vacunacion","jose.roque@tecmor.mx","123456","Ana Gallaga","Centro","Morelia","Michoacan","4434656736");
        e3=new Event(3,2,12,"Adoptamor","jose.roque@tecmor.mx","123456","Ana Gallaga","Centro","Morelia","Michoacan","4434656736");
        disponibles.add(e1);
        disponibles.add(e2);
        disponibles.add(e3);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new AdapterEvent(this,disponibles,R.layout.item_eandas) {
            @Override
            public void onDisplayRow(View view, int pos) {
                TextView title = (TextView) view.findViewById(R.id.category);
                TextView description = (TextView) view.findViewById(R.id.texto);
                TextView text = (TextView) view.findViewById(R.id.MainText);

                title.setText(disponibles.get(pos).getNombre());
                description.setText(disponibles.get(pos).getAsoc_id());
                text.setText(disponibles.get(pos).getCiudad());
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_events);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_events);
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
                Intent intent=new Intent(Events.this,Adoption.class);
                startActivity(intent);
            }break;
            case R.id.About:{
                Intent intent=new Intent(Events.this,About.class);
                startActivity(intent);
            }break;
            case R.id.Addpet:{
                Intent intent=new Intent(Events.this,CreateEditPet.class);
                startActivity(intent);
            }break;
            case R.id.Associations:{
                Intent intent=new Intent(Events.this,Associations.class);
                startActivity(intent);
            }break;
            case R.id.Events:{
                Intent intent=new Intent(Events.this,Events.class);
                startActivity(intent);
            }break;
            case R.id.Mypets:{
                Intent intent=new Intent(Events.this,myPets.class);
                startActivity(intent);

            }break;
            default:break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_events);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}