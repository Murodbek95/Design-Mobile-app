package com.example.dellgaming.myapplication.model;


import com.google.gson.annotations.SerializedName;

public class VerifyModel {
    @SerializedName("response")
    private VerifyModel response;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("sms_code")
    private String sms_code;
    public VerifyModel getResponse() {return response;}
    public String getUser_id() {return user_id;}
    public String getPassword() {return sms_code;}
}

