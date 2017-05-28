package com.mycaker.panu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class Adoption extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    PetsAvailable m1,m2,m3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ArrayList<PetsAvailable> disponibles = new ArrayList<PetsAvailable>();
        File filePath = getFileStreamPath("perro1.jpg");
        Drawable d = Drawable.createFromPath(filePath.toString());
       m1=new PetsAvailable(1,1,5,"Snowball","Perro","Pitbull","macho","gris","corto","2008/02/02","Jugeton",d);
        m2=new PetsAvailable(2,2,3,"Snowball","Perro","Pitbull","macho","gris","corto","2008/02/02","Jugeton",d);
      //  m3=new PetsAvailable();
        disponibles.add(m1);
        disponibles.add(m2);
        ListView lv = (ListView) findViewById(R.id.lv);
        //AdapterAvailable adapter = new AdapterAvailable(this, disponibles);
        //lv.setAdapter(adapter);

        lv.setAdapter(new MiAdaptador(this,disponibles,R.layout.item_adoptionavailable) {
            @Override
            public void onDisplayRow(View view, int pos) {
                TextView title = (TextView) view.findViewById(R.id.category);
                TextView description = (TextView) view.findViewById(R.id.texto);
                ImageView imagen = (ImageView) view.findViewById(R.id.imageView4);

                title.setText(disponibles.get(pos).getNombre());
                description.setText(disponibles.get(pos).getCaracteristicas());
                imagen.setImageResource(R.mipmap.ic_launcher);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_adoption);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_adoption);
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
                Intent intent=new Intent(Adoption.this,Adoption.class);
                startActivity(intent);
            }break;
            case R.id.About:{
                Intent intent=new Intent(Adoption.this,About.class);
                startActivity(intent);
            }break;
            case R.id.Addpet:{
                Intent intent=new Intent(Adoption.this,CreateEditPet.class);
                startActivity(intent);
            }break;
            case R.id.Associations:{
                Intent intent=new Intent(Adoption.this,Associations.class);
                startActivity(intent);
            }break;
            case R.id.Events:{
                Intent intent=new Intent(Adoption.this,Events.class);
                startActivity(intent);
            }break;
            case R.id.Mypets:{
                Intent intent=new Intent(Adoption.this,myPets.class);
                startActivity(intent);

            }break;
            default:break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_adoption);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
