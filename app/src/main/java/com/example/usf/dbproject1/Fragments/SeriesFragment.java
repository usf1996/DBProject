package com.example.usf.dbproject1.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject1.Entities.Series;
import com.example.usf.dbproject1.R;
import com.example.usf.dbproject1.RecyclerView.RVAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {

    public SeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_series, container, false);

        //Create a RecyclerView object and fix its size to improve performance
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.fragmentSeries_rv);
        rv.setHasFixedSize(true);

        //Create a layout to manage the position of the items in the recycler view
        //We choose the linear layout since we want the items to be in a vertical scrolling list
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(llm);

        //This is the placeholder of the data which will later be replaced with data from the DB
        List<Object> series = new ArrayList<>();
        series.add(new Series("Series 1", "Genre 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_camera));
        series.add(new Series("Series 2", "Genre 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_manage));
        series.add(new Series("Series 3", "Genre 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_gallery));

        //Create adapter that will be the middle man between the recycler view and the dataset
        RVAdapter adapter = new RVAdapter(series);
        rv.setAdapter(adapter);

        return rootView;
    }

}
