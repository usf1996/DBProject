package com.example.usf.dbproject.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.R;

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.fragmentProfile_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("My Info"));
        tabLayout.addTab(tabLayout.newTab().setText("My Stats"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        return rootView;
    }

}
