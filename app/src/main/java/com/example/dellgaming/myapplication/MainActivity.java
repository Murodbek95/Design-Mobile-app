package com.example.dellgaming.myapplication;

        import android.content.ContentValues;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.andrognito.pinlockview.IndicatorDots;
        import com.andrognito.pinlockview.PinLockListener;
        import com.andrognito.pinlockview.PinLockView;
        import com.example.dellgaming.myapplication.activity.MainPage;
        import com.example.dellgaming.myapplication.activity.Verifty;
        import com.example.dellgaming.myapplication.helper.Sqlhandler;
        import com.example.dellgaming.myapplication.model.SignModel;
        import com.example.dellgaming.myapplication.model.TokenModel;
        import com.example.dellgaming.myapplication.response.TokenResponse;
        import com.example.dellgaming.myapplication.rest.ApiClient;
        import com.example.dellgaming.myapplication.rest.ApiInterface;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SignModel Sign;

    private TokenResponse tokenresponse;
    private Button kirish;
    private EditText inputPhone;
    private EditText inputPassword;
    private PinLockView mPinLockView;
    private IndicatorDots mIndicatorDots;




    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
        String token = pref.getString("token","");
        Log.e("sad",token);
        if (token.isEmpty()){
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
                            }else {//if tugadi.
            checkToken(token);
            Intent tent = new Intent(MainActivity.this,
                    MainPage.class);
            startActivity(tent);
                            }
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
                Intent myIntent = new Intent(MainActivity.this,
                        Verifty.class);
                myIntent.putExtra("user_id",user_id);
                startActivity(myIntent);

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

    private void checkToken (final String token){
        ApiInterface apis = ApiClient.getClient().create(ApiInterface.class);
        Call<TokenResponse> tokencall = apis.CheckToken(API_KEY,token);
        tokencall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                tokenresponse=response.body();
                String userid1 = tokenresponse.getToken().getUserInfo().getId();
                Log.e("Userni Idisi",userid1);
            }
            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });

    }


}


