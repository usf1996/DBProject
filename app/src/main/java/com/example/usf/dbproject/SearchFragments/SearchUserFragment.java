package com.example.usf.dbproject.SearchFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.Entities.Movie;
import com.example.usf.dbproject.R;
import com.example.usf.dbproject.RecyclerViewAndAdapters.RecyclerViewAdapter;
import com.example.usf.dbproject.SearchActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchUserFragment extends Fragment implements SearchView.OnQueryTextListener {

    private List<Object> users = new ArrayList<>();
    private RecyclerView rv;
    private RecyclerViewAdapter rvadapter;


    public SearchUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.searchuser_fragment, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.searchUser_rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(llm);

        users = SearchActivity.movies;

        //Create adapter that will be the middle man between the recycler view and the dataset
        rvadapter = new RecyclerViewAdapter(users);
        rv.setAdapter(rvadapter);

        setHasOptionsMenu(true);

        return rootView;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem search = menu.findItem(R.id.mainToolbar_search);
        SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase().trim();

        final List<Object> filteredModelList = new ArrayList<>();
        for (Object movie : users) {
            Movie m = (Movie) movie;
            final String text = m.getTitle().toLowerCase();
            if (text.contains(newText)) {
                filteredModelList.add(movie);
            }
        }
        rvadapter.setFilter(filteredModelList);
        return false;
    }
}
