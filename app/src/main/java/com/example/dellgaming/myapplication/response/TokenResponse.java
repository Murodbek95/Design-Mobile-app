package com.example.dellgaming.myapplication.response;


import com.example.dellgaming.myapplication.model.ErrorModel;
import com.example.dellgaming.myapplication.model.TokenModel;
import com.google.gson.annotations.SerializedName;

public class TokenResponse {

    @SerializedName("error")
    private TokenModel error;
    @SerializedName("response")
    private TokenModel response;

    public TokenModel getXato() {return error;}
    public TokenModel getToken() {return response;}

}
