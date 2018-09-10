package com.example.dellgaming.myapplication.register.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dellgaming.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardRegister extends Fragment {


    public CardRegister() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_register, container, false);
        final Button blankcard = (Button)view.findViewById(R.id.email_sign_in_button);
        blankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(offline.this,
//                        CardRegisterAct.class);
//                startActivity(intent);
                BlankFragment fragment = new BlankFragment();
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
        // Inflate the layout for this fragment

    }

}
