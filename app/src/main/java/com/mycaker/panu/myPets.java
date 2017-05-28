package com.mycaker.panu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class myPets extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ManagerBD db;
    private ArrayList<Pet>pets;
    private ArrayList<String>img= new ArrayList<>();
    private ArrayList<String> names= new ArrayList<>();
     ViewPager vp;
    Pet e1,e2;
    customSwipe cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pets=new ArrayList<>();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_myPets);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        try {
            db= new ManagerBD(this, "panu", null, 1);
            loadPets();
            vp= (ViewPager) findViewById(R.id.viewPager);
            ArrayList<Fragment>fragments= new ArrayList<>();
            for (Pet p:pets) {
                MiFragmento fm= new MiFragmento(p);
                fragments.add(fm);
            }
            vp.setAdapter(new AdaptadorPaginas(getSupportFragmentManager(),fragments));


        } catch (Exception e) {
            //Toast.makeText(getApplicationContext(), "Error de viewPager"+e.toString(), Toast.LENGTH_LONG).show();
        }


    }

    public void loadPets() throws Exception {
        //cargar mascotas de la base de datos sqlite y guardarlas en un arraylist de mascotas...
        int petNum= db.lastid();
        //Toast.makeText(getApplicationContext(), "numero de tuplas "+petNum, Toast.LENGTH_LONG).show();
        for(int i=0; i<petNum;i++){
            try{
                Pet a= (Pet)db.showpet(i+1);
                a.setId(i+1);
                pets.add(a);
                img.add(a.getImagepath());
                names.add(a.getName());
            }
            catch(Exception ex){
                //Toast.makeText(getApplicationContext(), "Error en for "+ex.toString(), Toast.LENGTH_LONG).show();
            }
        }
        if(pets.size()==0){
            Toast.makeText(getApplicationContext(), "No tienes mascotas aún", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_myPets);
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
                Intent intent=new Intent(myPets.this,Adoption.class);
                startActivity(intent);
            }break;
            case R.id.About:{
                Intent intent=new Intent(myPets.this,About.class);
                startActivity(intent);
            }break;
            case R.id.Addpet:{
                Intent intent=new Intent(myPets.this,CreateEditPet.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }break;
            case R.id.Associations:{
                Intent intent=new Intent(myPets.this,Associations.class);
                startActivity(intent);
            }break;
            case R.id.Events:{
                Intent intent=new Intent(myPets.this,Events.class);
                startActivity(intent);
            }break;
            case R.id.Mypets:{
                Intent intent=new Intent(myPets.this,myPets.class);
                startActivity(intent);

            }break;
            default:break;

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_myPets);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    }
