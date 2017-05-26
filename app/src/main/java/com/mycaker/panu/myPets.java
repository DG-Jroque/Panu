package com.mycaker.panu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

    private ArrayList<Pet>pets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_myPets);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadPets();

    }

    public void savePets(){
        FileOutputStream fos = null;
        ObjectOutputStream os = null;
        try {
            fos = openFileOutput("PanuPets_File", MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(pets);
            os.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al Guardar los datos, vuelva a intentarlo", Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al Guardar los datos, vuelva a intentarlo", Toast.LENGTH_LONG).show();
        }
    }

    public void loadPets(){
        FileInputStream fis = null;
        ObjectInputStream is = null;
        try {
            fis = openFileInput("PanuPets_File");
            is = new ObjectInputStream(fis);
            pets= (ArrayList<Pet>) is.readObject();
            is.close();
            fis.close();
        } catch (FileNotFoundException e) {
            pets= new ArrayList<Pet>();
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Aun no se tienen mascotas", Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            e.printStackTrace();
            pets= new ArrayList<Pet>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            pets= new ArrayList<Pet>();
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
