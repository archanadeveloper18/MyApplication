package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    
    TextView productName;
    ImageView productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        //set data
        productName = findViewById(R.id.textcash);
        productImage = findViewById(R.id.imageView2);

        //get Intent
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");


        //Set data
        productName.setText(name);

        Glide.with(this)
                .load(image)
                .into(productImage);
    }
}
