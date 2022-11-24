package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //start main screen after 2seconds
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //start main screen
                startActivity(new Intent(Splash.this, LoginActivity.class));
                finish();//finish this activity
            }
        }, 2000);//2000 means 2 seconds
    }
}