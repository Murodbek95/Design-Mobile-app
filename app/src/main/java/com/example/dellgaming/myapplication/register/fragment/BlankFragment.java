package com.example.dellgaming.myapplication.register.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dellgaming.myapplication.R;
import com.example.dellgaming.myapplication.UserProfile;
import com.example.dellgaming.myapplication.UserProfileOnline;
import com.example.dellgaming.myapplication.offline;
import com.example.dellgaming.myapplication.register.activity.Register;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        final Button blankcard = (Button)view.findViewById(R.id.go_to_profile);
        blankcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(offline.this,
//                        CardRegisterAct.class);
//                startActivity(intent);
                System.out.println("checkline button goto pro");
                Intent intent = new Intent(getActivity(),UserProfileOnline.class);
                startActivity(intent);
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
