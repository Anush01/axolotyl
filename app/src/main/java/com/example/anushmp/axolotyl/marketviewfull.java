package com.example.anushmp.axolotyl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.textclassifier.TextLinks;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class marketviewfull extends AppCompatActivity {

    TextView bignumber;

    currentpricemodel cpr;
    Retrofit browser;
    OkHttpClient basicOkHttpapi;

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


        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + coinid
                + "&vs_currencies=" + currentcurrency;

        basicOkHttpapi = new OkHttpClient();
        Request.Builder requestbuilder = new Request.Builder();

        requestbuilder.url(url);

        Request resreq = requestbuilder.build();

        //Response response = null;
      //  try {
      //      response = basicOkHttpapi.newCall(resreq).execute();
      //  } catch (IOException e) {
        //    e.printStackTrace();
       // }


       // String outputfromresponse = response.body().toString();



        //bignumber.append("\n" + outputfromresponse);



        basicOkHttpapi.newCall(resreq).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String outputfromresponse = response.body().string();

                String finaloutput = "";
                String polishedoutput = "";

                for(int i =0; i<outputfromresponse.length()-3; i++){

                    String breaker1= ":{\"";
                    String breakerv2 = "inr";
                    String current = "" + outputfromresponse.charAt(i) + outputfromresponse.charAt(i+1) + outputfromresponse.charAt(i+2);

                    if(current.equals(breakerv2)){

                        for(int j = 0; j<outputfromresponse.length(); j++){

                            finaloutput = finaloutput + outputfromresponse.charAt(j);

                        }

                    }

                }

                for(int k =0; k<finaloutput.length(); k++){

                    String currentchar = "" + finaloutput.charAt(k);
                    String idontwantthis1 = "\"";
                    String idontwantthis2 = ":";
                    String idontwantthis3 = "}";
                    String idontwantthis4 = "{";

                    if(currentchar.equals(idontwantthis4)||currentchar.equals(idontwantthis1) || currentchar.equals(idontwantthis2) || currentchar.equals(idontwantthis3)){

                        continue;

                    }else{

                        polishedoutput = polishedoutput + currentchar;

                    }

                }

                String polishtheoutputmore = "";

                for(int l = 0; l<polishedoutput.length(); l++){

                    // level up

                    String breakerinr = "inr";

                    String current = "" + polishedoutput.charAt(l) + polishedoutput.charAt(l+1) + polishedoutput.charAt(l+2);

                    if(current.equals(breakerinr)){

                        for(int m = l+3; m<polishedoutput.length(); m++){

                            polishtheoutputmore = polishtheoutputmore + polishedoutput.charAt(m);

                        }

                        break;

                    }

                }







                String finalPolishedoutput = polishedoutput;
                String finalPolishedtheoutputmore = polishtheoutputmore;
                marketviewfull.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        bignumber.append("\n" + "₹" + finalPolishedtheoutputmore);
                    }
                });


            }
        });














    }
}