package com.example.dellgaming.myapplication.register.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dellgaming.myapplication.MainActivity;
import com.example.dellgaming.myapplication.R;
import com.example.dellgaming.myapplication.register.model.SignModel;
import com.example.dellgaming.myapplication.register.response.TokenResponse;
import com.example.dellgaming.myapplication.register.rest.ApiClient;
import com.example.dellgaming.myapplication.register.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Otabek on 09.07.2018.
 * Registiratsuyadan o'tish uchun uchun
 */



public class Register extends AppCompatActivity{


    private SignModel Sign;

    private TokenResponse tokenresponse;
    private Button kirish;
    private EditText inputPhone;
    private EditText inputPassword;
    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputPhone = (EditText) findViewById(R.id.phone);
        inputPassword = (EditText) findViewById(R.id.password);
        kirish = (Button) findViewById(R.id.kirish);
        kirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = inputPhone.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                checkLogin(phone,password);
            }


        });


    }


    private void checkLogin (final String phone, final String password){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<SignModel> call = apiService.AuthSignup(API_KEY, SIG, phone, password);
        call.enqueue(new Callback<SignModel>() {
            @Override
            public void onResponse(Call<SignModel> call, Response<SignModel> response) {
                Sign=response.body();
                String matn =Sign.getPhone().getMatn();
                Log.e("reg_matn",matn);
                String user_id =Sign.getPhone().getUser_id();
                Toast.makeText(getApplicationContext(),
                        "Kirish amalga oshirilmoqda iltimos kuting",
                        Toast.LENGTH_LONG)
                        .show();


                Log.e("user_id",user_id);
            }
            @Override
            public void onFailure(Call<SignModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Kirish amalga oshirilmadi, Iltimos Internetni tekshiring",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}

