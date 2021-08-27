package com.example.anushmp.axolotyl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class currency {

    @SerializedName("inr")
    @Expose
    private Integer inr;

    public Integer getInr() {
        return inr;
    }

    public void setInr(Integer inr) {
        this.inr = inr;
    }

}
