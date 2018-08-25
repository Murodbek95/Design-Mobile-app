package com.example.dellgaming.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dellgaming.myapplication.register.fragment.CardRegister;

import static android.content.ContentValues.TAG;


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
        View view = inflater.inflate(R.layout.fragment_offline_home, container, false);
        final Button regcard = (Button)view.findViewById(R.id.card_register);
        regcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(offline.this,
//                        CardRegisterAct.class);
//                startActivity(intent);
                CardRegister fragment = new CardRegister();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();
            }
        });
    /*    final Button sendFreeTextButton = (Button) view.findViewById(R.id.card_register);
        sendFreeTextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "reg button clicked");
                Intent intent = new Intent(getActivity(), CardRegister.class);
                startActivity(intent);
            }
        });*/

        // Inflate the layout for this fragment
        return view;
    }

}
