package com.example.dellgaming.myapplication.CreditPackage.extra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dellgaming.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class branches_map extends Fragment {


    public branches_map() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_branches_map, container, false);
    }

}
