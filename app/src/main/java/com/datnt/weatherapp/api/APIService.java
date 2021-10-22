package com.datnt.weatherapp.api;

import com.datnt.weatherapp.model.Current;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    // https://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely&appid=3ca6977b2d5c1657348a2103ba940df3

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    APIService apiService = retrofit.create(APIService.class);

    @GET("data/2.5/onecall")
    Call<Current> callAPI(@Query("lat") double lat,
                          @Query("lon") double lon,
                          @Query("exclude") String exclude,
                          @Query("appid") String key);
}
