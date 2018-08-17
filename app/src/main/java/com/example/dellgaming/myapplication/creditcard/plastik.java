package com.example.dellgaming.myapplication.creditcard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dellgaming.myapplication.R;
import com.example.dellgaming.myapplication.applications.UzcardOfflineFragment;


public class plastik extends Fragment implements View.OnClickListener {

    public plastik() {
        // Required empty public constructor
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_plastik, container, false);

        Button aboutBtn = (Button)rootView.findViewById(R.id.uzcard_open);

        aboutBtn.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.uzcard_open:
                fragment = new UzcardOfflineFragment();
                replaceFragment(fragment);
                break;


        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}