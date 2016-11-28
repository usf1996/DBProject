package com.example.usf.dbproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.usf.dbproject.Fragments.MovieFragment;
import com.example.usf.dbproject.Fragments.SeriesFragment;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Get the viewpager that will hold the different child fragments and setup the viewpager adapter
        final ViewPager viewPager = (ViewPager) findViewById(R.id.activitySearch_viewPager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.activitySearch_tabs);
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

    }

    //Add the different fragments to the viewpager adapter and give each tab a name
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MovieFragment(), "Movies");
        adapter.addFrag(new SeriesFragment(), "Series");
        adapter.addFrag(new SeriesFragment(), "Users");
        viewPager.setAdapter(adapter);
    }

}
