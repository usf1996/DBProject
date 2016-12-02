package com.example.usf.dbproject;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.usf.dbproject.Entities.Movie;
import com.example.usf.dbproject.Entities.Series;
import com.example.usf.dbproject.Fragments.ProfileFragment;
import com.example.usf.dbproject.Login.LoginActivity;
import com.example.usf.dbproject.Requests.MyMovieRequest;
import com.example.usf.dbproject.Requests.MySeriesRequest;
import com.example.usf.dbproject.ViewFragments.MovieViewFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static List<Object> mymovies, myseries;
    public static int ProfileORSearch;
    public static int ProfileORSearch1;
//    public static List<JSONArray> genresArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.ProfileORSearch = 0;

        Toolbar toolbar = (Toolbar) findViewById(R.id.appBarMain_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.activityMain_navHeader);
        navigationView.setNavigationItemSelectedListener(this);

        mymovies = new ArrayList<>();
        myseries = new ArrayList<>();

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        final Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        JSONArray moviesinfo = jsonResponse.getJSONArray("moviesinfo");
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
                            mymovies.add(movieToadd);
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

        MyMovieRequest myMovieRequest = new MyMovieRequest(responseListener);
        queue.add(myMovieRequest);

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

                            myseries.add(toAdd);
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

        MySeriesRequest myMovieRequest2 = new MySeriesRequest(responseListener2);
        queue.add(myMovieRequest2);


        /*genresArr = new ArrayList<>();

        final Response.Listener<String> responseListener2 = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success){
                        JSONArray moviegenres = jsonResponse.getJSONArray("moviegenres");
                        for(int i=0;i<moviegenres.length();i++){
                            genresArr.add(moviegenres.getJSONArray(0));
                        }

                    }

                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };


        MovieGenreRequest mgr = new MovieGenreRequest(responseListener2);
        RequestQueue queue2 = Volley.newRequestQueue(MainActivity.this);
        queue2.add(mgr);*/

        //Set profile screen as default screen on startup
        if (ProfileORSearch1 == 1) {
            FragmentManager manager1 = getSupportFragmentManager();
            manager1.beginTransaction().replace(R.id.contentMain_frameLayout, new MovieViewFragment()).commit();
        } else {
            ProfileORSearch1 = 0;
            ProfileFragment profileFragment1 = new ProfileFragment();
            FragmentManager manager1 = getSupportFragmentManager();
            manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
        }
        Toolbar tb1 = (Toolbar) findViewById(R.id.appBarMain_toolbar);
        tb1.setTitle("My Profile");

        //Defines what to do when the navigation header is pressed
        onNavHeaderPress();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
            ProfileORSearch1 = 0;
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_toolbar, menu);

        MenuItem search_item = menu.findItem(R.id.mainToolbar_searchMain);
        MenuItem sort_item = menu.findItem(R.id.mainToolbar_search);
        sort_item.setVisible(false);

        search_item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Logout by going back to the login page
        if (id == R.id.activityMainDrawer_logout) {
            Intent login_intent = new Intent(this, LoginActivity.class);
            startActivity(login_intent);
        } else if (id == R.id.activityMainDrawer_settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onNavHeaderPress() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.activityMain_navHeader);
        navigationView.setNavigationItemSelectedListener(this);

        //Get the navigation header object
        View headerview = navigationView.getHeaderView(0);

        //Go to profile page when the header is selected in the navigation header
        headerview.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment profileFragment1 = new ProfileFragment();
                FragmentManager manager1 = getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
                Toolbar tb1 = (Toolbar) findViewById(R.id.appBarMain_toolbar);
                tb1.setTitle("My Profile");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //Go to profile page when the profile picture is selected in the navigation header
        ImageView navHeaderMain_userImg = (ImageView) headerview.findViewById(R.id.navHeaderMain_userImg);
        navHeaderMain_userImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment profileFragment1 = new ProfileFragment();
                FragmentManager manager1 = getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
                Toolbar tb1 = (Toolbar) findViewById(R.id.appBarMain_toolbar);
                tb1.setTitle("My Profile");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //Go to profile page when the username is selected in the navigation header
        TextView navHeaderMain_userName = (TextView) headerview.findViewById(R.id.navHeaderMain_userName);
        navHeaderMain_userName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment profileFragment1 = new ProfileFragment();
                FragmentManager manager1 = getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
                Toolbar tb1 = (Toolbar) findViewById(R.id.appBarMain_toolbar);
                tb1.setTitle("My Profile");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        //Go to profile page when the user email is selected in the navigation header
        TextView navHeaderMain_userMail = (TextView) headerview.findViewById(R.id.navHeaderMain_userMail);
        navHeaderMain_userMail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileFragment profileFragment1 = new ProfileFragment();
                FragmentManager manager1 = getSupportFragmentManager();
                manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
                Toolbar tb1 = (Toolbar) findViewById(R.id.appBarMain_toolbar);
                tb1.setTitle("My Profile");
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }


}
