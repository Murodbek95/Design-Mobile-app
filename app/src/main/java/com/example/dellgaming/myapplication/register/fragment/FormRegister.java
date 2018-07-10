package com.example.dellgaming.myapplication.register.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dellgaming.myapplication.R;
import com.example.dellgaming.myapplication.UserProfile;
import com.example.dellgaming.myapplication.register.model.ErrorResponse;
import com.example.dellgaming.myapplication.register.model.SignModel;
import com.example.dellgaming.myapplication.register.rest.ApiClient;
import com.example.dellgaming.myapplication.register.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormRegister extends Fragment {
    private SignModel Sign;
    private Button kirish;
    private EditText inputPhone;
    private Button sms_kirish;
    private TextView sms_verify;
    private EditText inputSmscode;
    private EditText inputPassword;
    private ErrorResponse Errorm;
    private final static String API_KEY = "e315ce3850142a73a684b03aac892ae3";
    public static final String Token = "token";
    private String SIG = "98b3b38cf27ea990d86e448a69c936c2";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_form_register,container,false);

        inputPhone = (EditText) view.findViewById(R.id.phone);
        inputPassword = (EditText) view.findViewById(R.id.password);
        inputSmscode = (EditText) view.findViewById(R.id.sms_code);
        sms_verify = (TextView) view.findViewById(R.id.sms_verify);
        sms_kirish = (Button) view.findViewById(R.id.sms_check);
        kirish = (Button) view.findViewById(R.id.kirish);
        kirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = inputPhone.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                checkLogin(phone,password);
                inputPhone.setEnabled(false);
                inputPassword.setEnabled(false);
                kirish.setVisibility(View.INVISIBLE);
                sms_verify.setVisibility(View.VISIBLE);
                inputSmscode.setVisibility(View.VISIBLE);
                sms_kirish.setVisibility(View.VISIBLE);


                sms_kirish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences pref = getActivity().getSharedPreferences("UserId",0);
                        String user_id = pref.getString("user_id","");
                        String sms = inputSmscode.getText().toString().trim();
                        checkSmsCode(user_id,sms);
                    }
                    });
            }
        });

        return view;





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

                SharedPreferences pref = getActivity().getSharedPreferences("UserId",0);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("user_id",user_id);
                editor.apply();



            }
            @Override
            public void onFailure(Call<SignModel> call, Throwable t) {
                String asd = getActivity().getResources().getString(R.string.interner_error);

                Toast.makeText(getActivity(),asd,Toast.LENGTH_SHORT).show();
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
                if (response.isSuccessful()){
                    String javob= Errorm.getTokenResponse().getToken();
                    Log.e("Natija:", javob);
                    SharedPreferences pref = getActivity().getSharedPreferences("MyPref",0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token",javob);
                    editor.apply();
                    Intent myintent;
                    myintent = new Intent(getActivity(), UserProfile.class);

                    String token = pref.getString("token","");
                    myintent.putExtra("token",token);
                    startActivity(myintent);
                }else {
                    String xato_code =Errorm.getError().getErrorc();
                    Log.e("xato kodi",xato_code);
                    String xato= Errorm.getError().getError_msg();
                    Log.e("Xato:", xato);
                    SharedPreferences pref = getActivity().getSharedPreferences("MyPref",0);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("Xato",xato);
                    editor.apply();
                }



                SharedPreferences pref = getActivity().getSharedPreferences("MyPref",0);
                String token = pref.getString("token","");
                String xato = pref.getString("Xato","");

                Log.e("adss",token);
                Log.e("sadasd",xato);


            }
            @Override
            public void onFailure(Call<ErrorResponse> call, Throwable t) {
                String asd = getActivity().getResources().getString(R.string.interner_error);
                Toast.makeText(getActivity(),asd,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
