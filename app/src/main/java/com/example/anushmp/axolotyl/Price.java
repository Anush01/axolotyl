package com.example.anushmp.axolotyl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Price {

    @SerializedName("bitcoin")
    @Expose
    private Bitcoin bitcoin;

    public Bitcoin getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(Bitcoin bitcoin) {
        this.bitcoin = bitcoin;
    }

}
