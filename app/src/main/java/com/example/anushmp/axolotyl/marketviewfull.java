package com.example.anushmp.axolotyl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class marketviewfull extends AppCompatActivity {

    TextView bignumber;

    currentpricemodel cpr;
    Retrofit browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketviewfull);

        Intent i = getIntent();

        String coinid= i.getStringExtra("id");
        String currentcurrency = "inr";




        bignumber = findViewById(R.id.bignumber);

        browser = networker.getRetrofitObject();
        coingeckoapi api = browser.create(coingeckoapi.class);














        if(coinid != null){bignumber.setText(coinid);}


    }
}