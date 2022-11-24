package com.example.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView bookBtn;
    private CardView newsBtn;
    private CardView cartBtn;
    private CardView logOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bookBtn = findViewById(R.id.cardBook);
        newsBtn = findViewById(R.id.cardNews);
        logOutBtn = findViewById(R.id.cardLogoutBtn);

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
                Toast.makeText(MainActivity.this,"Successfully Logout", Toast.LENGTH_SHORT).show();
                openLogout();

            }
        });
    }

    public void openBook(){
        Intent intent = new Intent(this, Books.class);
        startActivity(intent);
    }

    public void openNews(){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }

    public void openLogout(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}