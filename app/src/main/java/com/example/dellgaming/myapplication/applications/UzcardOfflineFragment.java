package com.example.dellgaming.myapplication.applications;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.dellgaming.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UzcardOfflineFragment extends Fragment {


    public UzcardOfflineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_uzcard_offline, container, false);

        Switch job_info = (Switch) rootView.findViewById(R.id.work_info);

        Boolean switchState = job_info.isChecked();

        if(job_info.isChecked())
        {

        }
        return rootView;
    }



}
