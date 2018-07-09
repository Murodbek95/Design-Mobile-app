package com.example.dellgaming.myapplication.register.response;


import com.example.dellgaming.myapplication.register.model.TokenModel;
import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("error")
    private TokenModel error;
    @SerializedName("response")
    private TokenModel response;

    public TokenModel getXato() {return error;}
    public TokenModel getToken() {return response;}

}
