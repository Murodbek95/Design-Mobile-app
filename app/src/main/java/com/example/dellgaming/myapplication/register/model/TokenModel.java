package com.example.dellgaming.myapplication.register.model;

import com.google.gson.annotations.SerializedName;



public class TokenModel {

    @SerializedName("user_info")
    private UserInfoModel user_info;


    public UserInfoModel getUserInfo() {return user_info;}

}
