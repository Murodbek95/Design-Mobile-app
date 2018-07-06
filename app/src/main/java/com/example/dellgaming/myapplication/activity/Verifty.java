package com.example.dellgaming.myapplication.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellgaming.myapplication.MainActivity;
import com.example.dellgaming.myapplication.R;


import com.example.dellgaming.myapplication.model.ErrorResponse;


import com.example.dellgaming.myapplication.rest.ApiClient;
import com.example.dellgaming.myapplication.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Verifty extends AppCompatActivity {
    private EditText inputSms_code;
    private TextView mTimer;
    SharedPreferences.Editor editor;
    private EditText inputToken;
    private Button btnSend;
    private Button btntoken;
    SharedPreferences shpref;
    private String sad;
    private String asd;
    private ErrorResponse Errorm;
    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    public static final String Token = "token";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifty);

        mTimer = (TextView) findViewById(R.id.textView);
        sad = getString(R.string.verify_status);
        asd = getString(R.string.verify_status1);
        //Создаем таймер обратного отсчета на 30 секунд с шагом отсчета
        //в 1 секунду (задаем значения в миллисекундах):
        new CountDownTimer(30000, 1000) {

            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {
                mTimer.setText(asd+ millisUntilFinished / 1000 + sad);
            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
                mTimer.setText("Бабах!");
            }
        }
                .start();


        inputSms_code = (EditText) findViewById(R.id.sms_code);
        Intent intent = getIntent();
        final String user = intent.getStringExtra("user_id");
        btnSend = (Button) findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sms_code= inputSms_code.getText().toString().trim();
                checkSmsCode(user,sms_code);
            }
        });
    }
    private void checkSmsCode (final String user_id, final String sms_code){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ErrorResponse> call = apiService.CheckVerify(API_KEY, user_id, sms_code);
          call.enqueue(new Callback<ErrorResponse>() {
            @Override
            public void onResponse(Call<ErrorResponse> call, Response<ErrorResponse> response) {
                Errorm=response.body();
                String javob= Errorm.getTokenResponse().getToken();
                Log.e("Natija:", javob);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token",javob);
                    editor.apply();
                    String token = pref.getString("token","");


                Log.e("Saqlashni tekshirish",token);
                }
            @Override
            public void onFailure(Call<ErrorResponse> call, Throwable t) {
            }
        });
    }



}
