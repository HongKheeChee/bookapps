package com.example.androidgroup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class book2 extends AppCompatActivity {

    private Button buyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);

        buyBtn = findViewById(R.id.BuyBook2);

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.amazon.com/gp/product/1704852358/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=1704852358&linkCode=as2&tag=adazing0e-20&linkId=ed3efb459e3de9d70656e6102ba3e2d6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}