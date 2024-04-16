package com.example.nguyenphanhuy.Interface;

import com.example.nguyenphanhuy.Activity.LoginRequest;
import com.example.nguyenphanhuy.Api.Token;

import java.net.URI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Methods {
    static String BASE_URL = "https://reqres.in/";

    public static Retrofit  getRetrofitInstance() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
    @POST("api/login")
    Call<Token> login(@Body LoginRequest loginRequest);
}

