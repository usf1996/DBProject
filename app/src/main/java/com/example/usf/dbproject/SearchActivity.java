package com.example.usf.dbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.usf.dbproject.Entities.Movie;
import com.example.usf.dbproject.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<Object> movies, series, users;
    private RecyclerView rv;
    private RecyclerViewAdapter rvadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SearchView searchView = (SearchView) findViewById(R.id.activitySearch_searchview);
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(this);

        rv = (RecyclerView) findViewById(R.id.contentSearch_rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "Genre 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.myphoto));
        movies.add(new Movie("Movie 2", "Genre 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_manage));
        movies.add(new Movie("Movie 3", "Genre 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consectetur", R.drawable.ic_menu_gallery));

        //Create adapter that will be the middle man between the recycler view and the dataset
        rvadapter = new RecyclerViewAdapter(movies);
        rv.setAdapter(rvadapter);

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
