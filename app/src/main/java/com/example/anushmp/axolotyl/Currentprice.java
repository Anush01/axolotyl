package com.example.anushmp.axolotyl;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Currentprice {

    @SerializedName("id")
    @Expose
    private Id id;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

}
