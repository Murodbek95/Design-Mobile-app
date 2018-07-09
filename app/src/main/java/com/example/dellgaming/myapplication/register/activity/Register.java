package com.example.dellgaming.myapplication.register.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
 * Registiratsiyadan o'tish uchun
 */



public class Register extends FragmentActivity{


    private SignModel Sign;

    private TokenResponse tokenresponse;
    private Button kirish;
    private EditText inputPhone;
    private EditText inputPassword;
    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

//
//        inputPhone = (EditText) findViewById(R.id.phone);
//        inputPassword = (EditText) findViewById(R.id.password);
//        kirish = (Button) findViewById(R.id.kirish);
//        kirish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String phone = inputPhone.getText().toString().trim();
//                String password = inputPassword.getText().toString().trim();
//                checkLogin(phone,password);
//            }
//
//
//        });


    }


}

