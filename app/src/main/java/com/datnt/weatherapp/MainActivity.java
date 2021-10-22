package com.datnt.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.datnt.weatherapp.api.APIService;
import com.datnt.weatherapp.model.Current;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // https://api.openweathermap.org/data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely&appid=3ca6977b2d5c1657348a2103ba940df3


    Button btnCallAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCallAPI = findViewById(R.id.btnCallAPI);

        btnCallAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAPI();
            }
        });
    }

    public void callAPI() {
        APIService.apiService.callAPI(21.027764f, 105.834160f, "minutely", "3ca6977b2d5c1657348a2103ba940df3").enqueue(new Callback<Current>() {
            @Override
            public void onResponse(Call<Current> call, Response<Current> response) {
                Current current = response.body();

                Log.d("2tdp", "onResponse: " + current);
                Toast.makeText(MainActivity.this, "Call success!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Current> call, Throwable t) {

            }
        });
    }
}