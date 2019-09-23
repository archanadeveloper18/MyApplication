package com.example.myapplication.network;

import com.example.myapplication.model.items;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("bins/1eg1nx")
    Call<List<items>> getitems();

}
