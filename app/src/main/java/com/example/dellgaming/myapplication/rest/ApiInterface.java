package com.example.dellgaming.myapplication.rest;


import retrofit2.Call;

import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.dellgaming.myapplication.model.ErrorResponse;
import com.example.dellgaming.myapplication.model.SignModel;

import com.example.dellgaming.myapplication.response.TokenResponse;


public interface ApiInterface {

 @GET("auth.signup")
    Call<SignModel> AuthSignup(@Query("api_key") String apiKey, @Query("sig") String sig, @Query("phone") String phone, @Query("password1") String password);

 @GET("auth.verify")
 Call<ErrorResponse> CheckVerify(@Query("api_key") String apiKey, @Query("user_id") String user_id, @Query("sms_code") String sms_code);

 @GET("auth.token")
 Call<TokenResponse> CheckToken(@Query("api_key") String apiKey, @Query("token") String token);



}
