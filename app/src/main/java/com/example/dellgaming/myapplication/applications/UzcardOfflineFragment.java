package com.example.dellgaming.myapplication.applications;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.Toast;

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

       final CheckBox checkboxvariable = (CheckBox) rootView.findViewById(R.id.work_info);
       final TableLayout tableLayout = (TableLayout)rootView.findViewById(R.id.work_panel);
        tableLayout.setVisibility(View.GONE);;
        checkboxvariable.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (checkboxvariable.isChecked()) {
                    tableLayout.setVisibility(View.VISIBLE);
                } else {
                    tableLayout.setVisibility(View.GONE);
                }

            }
        });

        return rootView;

    }


}
