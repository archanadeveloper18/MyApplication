package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

         ImageView imageViewGrocery = findViewById(R.id.grocery);
         TextView textViewGrocery = findViewById(R.id.grocerytext);

        ImageView imageViewPhone = findViewById(R.id.phone);
        TextView textViewPhone = findViewById(R.id.phonetext);

        ImageView imageViewHome= findViewById(R.id.home);
        TextView textViewHome = findViewById(R.id.hometext);

        ImageView imageViewTravel = findViewById(R.id.travel);
        TextView textViewTravel= findViewById(R.id.traveltext);

        ImageView imageViewPharmacy = findViewById(R.id.pharmacy);
        TextView textViewPharmacy = findViewById(R.id.phonetext);

        ImageView imageViewRestaurant = findViewById(R.id.restaurant);
        TextView textViewRestaurant = findViewById(R.id.restauranttext);

    }
}
