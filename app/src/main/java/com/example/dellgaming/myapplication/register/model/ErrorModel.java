package com.example.dellgaming.myapplication.register.model;

import com.google.gson.annotations.SerializedName;


public class ErrorModel {
    @SerializedName("error_msg")
    private String error_msg;
    @SerializedName("error_code")
    private String error_code;
    @SerializedName("auth_token")
    private String auth_token;

    public String getError_msg() {return error_msg;}
    public String getErrorc() {return error_code;}
    public String getToken() {return auth_token;}

}
