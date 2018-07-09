package com.example.dellgaming.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dellgaming.myapplication.R;
import com.example.dellgaming.myapplication.register.activity.Register;

public class UserProfile extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_profile);
        Intent intent = getIntent();
        String token = intent.getStringExtra("token");

    }
}
