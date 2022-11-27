package com.example.androidgroup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class book1 extends AppCompatActivity {

    private Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);

        buyBtn = findViewById(R.id.BuyBook1);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/gp/product/0553582011/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=0553582011&linkCode=as2&tag=adazing0e-20&linkId=c016d588cefa4059505b837e4ebd12d1";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}