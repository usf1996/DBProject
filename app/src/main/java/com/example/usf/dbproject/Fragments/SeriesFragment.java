package com.example.usf.dbproject.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.MainActivity;
import com.example.usf.dbproject.R;
import com.example.usf.dbproject.RecyclerViewAndAdapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {

    private List<Object> myseries = new ArrayList<>();

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

        myseries = MainActivity.myseries;


        //Create adapter that will be the middle man between the recycler view and the dataset
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(myseries);
        rv.setAdapter(adapter);

        return rootView;
    }

}
