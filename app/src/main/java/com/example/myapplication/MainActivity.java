package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.model.items;
import com.example.myapplication.network.APIclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    GridView grideView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grideView = findViewById(R.id.gridView);

        //make network call
        Call<List<items>> call = APIclient.apIinterface().getitems();

        call.enqueue(new Callback<List<items>>() {
            @Override
            public void onResponse(Call<List<items>> call, Response<List<items>> response) {
                if(response.isSuccessful()){

                    customAdapter = new CustomAdapter(response.body(),MainActivity.this);

                    grideView.setAdapter(customAdapter);

                }else{
                    Toast.makeText(getApplicationContext()," An error occured ", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<items>> call, Throwable t) {
                Toast.makeText(getApplicationContext()," An error occured "+ t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

}
