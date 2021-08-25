package com.example.anushmp.axolotyl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface coingeckoapi {


    @GET("coins/list")
    Call<List<currencyDataModel>> getcurrencylist();

}
