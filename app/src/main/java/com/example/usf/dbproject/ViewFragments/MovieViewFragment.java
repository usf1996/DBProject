package com.example.usf.dbproject.ViewFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieViewFragment extends Fragment {


    public MovieViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movieview, container, false);
    }

}
