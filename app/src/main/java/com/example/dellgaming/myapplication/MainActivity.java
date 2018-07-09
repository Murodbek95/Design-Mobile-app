package com.example.dellgaming.myapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.andrognito.pinlockview.IndicatorDots;
        import com.andrognito.pinlockview.PinLockView;
        import com.example.dellgaming.myapplication.register.activity.Register;
        import com.example.dellgaming.myapplication.register.fragment.FormRegister;
        import com.example.dellgaming.myapplication.register.model.SignModel;
        import com.example.dellgaming.myapplication.register.response.TokenResponse;
        import com.example.dellgaming.myapplication.register.rest.ApiClient;
        import com.example.dellgaming.myapplication.register.rest.ApiInterface;
        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SignModel Sign;
    private ActionBar toolbar;
    private TokenResponse tokenresponse;
    private Button register;





    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    private Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                //Registrastiya bosilganda shu activtyga o'tkazish kerak
                Intent tent = new Intent(MainActivity.this,
                Register.class);
                startActivity(tent);
            }
        });
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
        String token = pref.getString("token","");
        Log.e("sad",token);



//            Intent tent = new Intent(MainActivity.this,
//                    UserProfile.class);
//            startActivity(tent);

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


