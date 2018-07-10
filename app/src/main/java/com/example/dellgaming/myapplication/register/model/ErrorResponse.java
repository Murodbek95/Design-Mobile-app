package com.example.dellgaming.myapplication.register.model;

import com.google.gson.annotations.SerializedName;


public class ErrorResponse {
    @SerializedName("error")
    private ErrorModel error;
    @SerializedName("response")
    private ResponseModel response;

    public ErrorModel getError() {return error;}
    public ResponseModel getTokenResponse() {return response;}
}

