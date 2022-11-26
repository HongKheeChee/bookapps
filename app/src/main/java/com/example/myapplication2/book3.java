package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class book3 extends AppCompatActivity {

    private Button buybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        buybtn = findViewById(R.id.BuyBook3);

        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.amazon.com/Four-Winds-Novel-Kristin-Hannah/dp/1250178606?asc_refurl=https%3A%2F%2Fwww.businessinsider.com%2F&asc_source=browser&asc_campaign=commerce-pra&tag=biauto-52733-20";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}