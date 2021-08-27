package com.example.anushmp.axolotyl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class currentpricemodel {

    @SerializedName("currency")
    @Expose
    private currency currency;

    public currency getCurrency() {
        return currency;
    }

    public void setCurrency(currency currency) {
        this.currency = currency;
    }

}
