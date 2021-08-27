package com.example.anushmp.axolotyl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class marketviewfull extends AppCompatActivity {

    TextView bignumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketviewfull);

        Intent i = getIntent();

        String coinid= i.getStringExtra("id");


        bignumber = findViewById(R.id.bignumber);

        if(coinid != null){bignumber.setText(coinid);}


    }
}