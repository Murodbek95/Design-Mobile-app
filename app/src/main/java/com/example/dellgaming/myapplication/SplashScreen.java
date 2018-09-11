package com.example.dellgaming.myapplication;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_splash_screen);
//        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
        Intent intent = new Intent(this, offline.class);
        startActivity(intent);
        finish();
    }
}
