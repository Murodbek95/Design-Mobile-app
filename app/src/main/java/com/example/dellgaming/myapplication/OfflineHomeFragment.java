package com.example.dellgaming.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dellgaming.myapplication.register.fragment.CardRegister;


/**
 * A simple {@link Fragment} subclass.
 */
public class OfflineHomeFragment extends Fragment {


    public OfflineHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Button regcard = (Button)findViewById(R.id.card_register);
        regcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(offline.this,
//                        CardRegisterAct.class);
//                startActivity(intent);
                CardRegister fragment = new CardRegister();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offline_home, container, false);
    }

}
