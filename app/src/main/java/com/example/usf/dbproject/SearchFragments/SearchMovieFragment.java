package com.example.usf.dbproject.SearchFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usf.dbproject.Entities.Movie;
import com.example.usf.dbproject.R;
import com.example.usf.dbproject.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchMovieFragment extends Fragment implements SearchView.OnQueryTextListener {

    private List<Object> movies, series, users;
    private RecyclerView rv;
    private RecyclerViewAdapter rvadapter;


    public SearchMovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.searchmovie_fragment, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.searchMovie_rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        rv.setLayoutManager(llm);

        movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "Genre 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.myphoto));
        movies.add(new Movie("Movie 2", "Genre 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_manage));
        movies.add(new Movie("Movie 3", "Genre 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_gallery));

        //Create adapter that will be the middle man between the recycler view and the dataset
        rvadapter = new RecyclerViewAdapter(movies);
        rv.setAdapter(rvadapter);

        SearchView searchView = (SearchView) rootView.findViewById(R.id.searchMovie_searchview);
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(this);

        return rootView;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();

        final List<Object> filteredModelList = new ArrayList<>();
        for (Object movie : movies) {
            Movie m = (Movie) movie;
            final String text = m.getMovie_title().toLowerCase();
            if (text.contains(newText)) {
                filteredModelList.add(movie);
            }
        }
        rvadapter.setFilter(filteredModelList);
        return false;
    }
}
