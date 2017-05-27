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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.view.MenuItem;
import android.widget.TextView;

public class Events extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        sqlThread.start();
        tv=(TextView) findViewById(R.id.pruebasql);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
    Thread sqlThread = new Thread() {
        public void run() {
            try {
                Class.forName("org.postgresql.Driver");
                // "jdbc:postgresql://IP:PUERTO/DB", "USER", "PASSWORD");
                Connection conn = DriverManager.getConnection(
                        "jdbc:postgresql://siccuautla.ddns.net:5432/panu", "panu", "123456");
                //En el stsql se puede agregar cualquier consulta SQL deseada.
                String stsql = "Select version()";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(stsql);
                rs.next();
                System.out.println(rs.getString(1));
                conn.close();
            } catch (SQLException se) {
                System.out.println("oops! No se puede conectar. Error: " + se.toString());
            } catch (ClassNotFoundException e) {
                System.out.println("oops! No se encuentra la clase. Error: " + e.getMessage());
            }
        }
    };
}
