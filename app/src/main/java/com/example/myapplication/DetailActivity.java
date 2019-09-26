package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    
    TextView productName;
    ImageView productImage;
    TextView productcash;
    TextView productdescription;
    TextView productterms;
    TextView productinstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        //set data to get by their id.
        productName = findViewById(R.id.textcash);
        productImage = findViewById(R.id.imageView2);
        productcash = findViewById(R.id.textname);
        productdescription = findViewById(R.id.textdescription);
        productterms = findViewById(R.id.textterms);
        productinstore = findViewById(R.id.instore);

        //get Intent
        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        String value = intent.getStringExtra("value");
        String description = intent.getStringExtra("description");
        String terms = intent.getStringExtra("terms");


        //Set data to display in detail Screen.
        productName.setText(name);
        productcash.setText(value);
        productdescription.setText(description);
        productterms.setText(terms);

        Glide.with(this)
                .load(image)
                .into(productImage);
    }
}
