package com.example.dellgaming.myapplication.register.model;

import com.google.gson.annotations.SerializedName;


public class ErrorResponse {
    @SerializedName("error")
    private ErrorModel error;
    @SerializedName("response")
    private ErrorModel response;

    public ErrorModel getXato() {return error;}
    public ErrorModel getTokenResponse() {return response;}
}

