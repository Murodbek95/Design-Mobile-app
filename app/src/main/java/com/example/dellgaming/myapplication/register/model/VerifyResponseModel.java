package com.example.dellgaming.myapplication.register.model;


import com.google.gson.annotations.SerializedName;

public class VerifyResponseModel {



    @SerializedName("user_id")
    private String user_id;

    @SerializedName("auth_token")
    private String auth_token;

    public String getUser_id() {return user_id;}
    public String getAuth_token() {return auth_token;}
}
