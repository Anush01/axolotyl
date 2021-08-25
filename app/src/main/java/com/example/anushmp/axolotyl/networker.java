package com.example.anushmp.axolotyl;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class networker {

    public static final String baseurlforapi = "https://api.coingecko.com/api/v3/";

    public static Retrofit getRetrofitObject(){

        GsonConverterFactory gsf = GsonConverterFactory.create();

        OkHttpClient.Builder htb = new OkHttpClient.Builder();

        Retrofit.Builder rfb = new Retrofit.Builder();

        OkHttpClient ohc = htb.build();

        rfb.baseUrl(baseurlforapi);
        rfb.addConverterFactory(gsf);
        rfb.client(ohc);

        Retrofit retrofitobject = rfb.build();


        return retrofitobject;


    }


}
