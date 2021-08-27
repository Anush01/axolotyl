package com.example.anushmp.axolotyl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface coingeckoapi {


    @GET("coins/list")
    Call<List<currencyDataModel>> getcurrencylist();

   @GET("/simple/price")
    Call<currentpricemodel> getprice(@Query("ids") String currencyid, @Query("vs_currencies") String currency);

}
