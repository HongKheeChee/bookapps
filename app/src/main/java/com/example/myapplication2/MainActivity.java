package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView bookBtn;
    private CardView newsBtn;
    private CardView logOutBtn;
    private CardView sellbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bookBtn = findViewById(R.id.cardBook);
        newsBtn = findViewById(R.id.cardNews);
        logOutBtn = findViewById(R.id.cardLogoutBtn);
        sellbook = findViewById(R.id.cardSellBook);

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook();
            }
        });

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNews();
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Successfully Logout", Toast.LENGTH_SHORT).show();
                openLogout();

            }
        });

        sellbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensellbook();
            }
        });
    }

    public void openBook() {
        Intent intent = new Intent(this, DashboardUserActivity.class);
        startActivity(intent);
    }

    public void openNews(){
        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
        startActivity(intent);
    }

    public void openLogout() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void opensellbook() {
        Intent intent = new Intent(MainActivity.this, Sellbooks.class);
        startActivity(intent);
    }
}