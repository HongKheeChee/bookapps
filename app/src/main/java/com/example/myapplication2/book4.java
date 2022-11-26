package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class book4 extends AppCompatActivity {

    private Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book4);

        buyBtn = findViewById(R.id.BuyBook4);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/Midnight-Library-Novel-Matt-Haig/dp/0525559477?asc_refurl=https%3A%2F%2Fwww.businessinsider.com%2F&asc_source=browser&asc_campaign=commerce-pra&tag=biauto-52733-20";
                Intent i = new Intent(Intent.ACTION_VIEW);

                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}