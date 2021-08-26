package com.example.anushmp.axolotyl;

public class UserModel {

    private String email;

    private String password;

    public UserModel(){}

    public UserModel(String email, String password){

        this.email = email;
        this.password = password;

    }

    public String getEmail(){

        return email;
    }

    public String getPassword(){

        return password;

    }

}
