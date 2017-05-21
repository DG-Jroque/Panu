package com.mycaker.panu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Handler;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(splash.this, myPets.class));
                finish();
            }
        }, secondsDelayed * 1000);
    }


}
