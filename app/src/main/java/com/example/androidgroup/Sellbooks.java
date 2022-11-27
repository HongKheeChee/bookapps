package com.example.androidgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Sellbooks extends AppCompatActivity {

    ImageView backBtn;
    Button expand1;
    Button expand2;
    Button expand3;
    Button expand4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sellbooks);

        //Hooks
        backBtn = findViewById(R.id.back_pressed);
        expand1 = findViewById(R.id.Expand_1);
        expand2 = findViewById(R.id.Expand_2_read);
        expand3 = findViewById(R.id.Expand_3);
        expand4= findViewById(R.id.Expand_4);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sellbooks.super.onBackPressed();
            }
        });

        expand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook1();
            }
        });

        expand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook2();
            }
        });

        expand3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook3();
            }
        });

        expand4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBook4();
            }
        });

    }
    public void openBook1() {
        Intent intent = new Intent(this, book1.class);
        startActivity(intent);
    }

    public void openBook2(){
        Intent intent = new Intent(this, book2.class);
        startActivity(intent);
    }

    public void openBook3(){
        Intent intent = new Intent(this,book3.class);
        startActivity(intent);
    }

    public void openBook4(){
        Intent intent = new Intent(this,book4.class);
        startActivity(intent);
    }
}