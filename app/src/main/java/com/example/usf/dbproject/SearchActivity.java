package com.example.usf.dbproject;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.usf.dbproject.Entities.Movie;
import com.example.usf.dbproject.Entities.Series;
import com.example.usf.dbproject.RecyclerViewAndAdapters.ViewPagerAdapter;
import com.example.usf.dbproject.Requests.SearchSeriesRequest;
import com.example.usf.dbproject.Requests.SearchMovieRequest;
import com.example.usf.dbproject.SearchFragments.SearchMovieFragment;
import com.example.usf.dbproject.SearchFragments.SearchSeriesFragment;
import com.example.usf.dbproject.SearchFragments.SearchUserFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    public static List<Object> movies, series, users;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MainActivity.ProfileORSearch = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activitySearch_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movies = new ArrayList<>();
        series = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(SearchActivity.this);

        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        JSONArray moviesinfo = jsonResponse.getJSONArray("movieinfo");
                        JSONObject movie;
                        for (int i = 0; i < moviesinfo.length(); i++) {
                            movie = moviesinfo.getJSONObject(i);
                            Movie movieToadd = new Movie(
                                    Integer.parseInt(movie.getString("movieID")),
                                    Integer.parseInt(movie.getString("companyID")),
                                    movie.getString("title"),
                                    Integer.parseInt(movie.getString("duration")),
                                    movie.getString("releaseDate"),
                                    movie.getString("storyline"),
                                    movie.getString("contentRating"));
                            movies.add(movieToadd);
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                        builder.setMessage("Loading Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };


        SearchMovieRequest searchMovieRequest = new SearchMovieRequest(responseListener);
        queue.add(searchMovieRequest);

        final Response.Listener<String> responseListener2 = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        JSONArray seriesinfo = jsonResponse.getJSONArray("seriesinfo");
                        JSONObject serie;
                        for (int i = 0; i < seriesinfo.length(); i++) {
                            serie = seriesinfo.getJSONObject(i);
                            Series toAdd = new Series();
                            toAdd.setTitle(serie.getString("title"));
                            toAdd.setCompanyID(Integer.parseInt(serie.getString("companyID")));
                            toAdd.setSeriesID(Integer.parseInt(serie.getString("seriesID")));
                            toAdd.setContentRating(serie.getString("contentRating"));
                            toAdd.setStoryline(serie.getString("storyline"));
                            toAdd.setDuration(Integer.parseInt(serie.getString("duration")));
                            toAdd.setStartDate(serie.getString("startDate"));

                            toAdd.setEndDate("test"); //Ntebeh hay yimkin ta3mol error la2ano null;

                            series.add(toAdd);
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                        builder.setMessage("Loading Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };


        SearchSeriesRequest searchSeriesRequest = new SearchSeriesRequest(responseListener2);
        queue.add(searchSeriesRequest);

        viewPager = (ViewPager) findViewById(R.id.activitySearch_viewpager);
        setupViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_toolbar, menu);

        MenuItem mainsearch = menu.findItem(R.id.mainToolbar_searchMain);
        mainsearch.setVisible(false);

        MenuItem search = menu.findItem(R.id.mainToolbar_search);
        search.expandActionView();

        return true;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SearchMovieFragment(), "Movies");
        adapter.addFrag(new SearchSeriesFragment(), "Series");
        adapter.addFrag(new SearchUserFragment(), "Users");
        viewPager.setAdapter(adapter);

    }

}
