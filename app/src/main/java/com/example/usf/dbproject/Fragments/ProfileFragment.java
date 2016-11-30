package com.example.usf.dbproject.Fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.Login.LoginActivity;
import com.example.usf.dbproject.MainActivity;
import com.example.usf.dbproject.R;
import com.example.usf.dbproject.SearchActivity;
import com.example.usf.dbproject.ViewPagerAdapter;

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile,container,false);
        MainActivity.ProfileORSearch = 0;

        //Get the viewpager that will hold the different child fragments and setup the viewpager adapter
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.fragmentProfile_viewPager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.fragmentProfile_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Get the appropriate fragment when a tab is pressed
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    //Add the different fragments to the viewpager adapter and give each tab a name
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new MovieFragment(), "My Movies");
        adapter.addFrag(new SeriesFragment(), "My Series");
        adapter.addFrag(new SeriesFragment(), "My Stats");
        viewPager.setAdapter(adapter);
    }
}
