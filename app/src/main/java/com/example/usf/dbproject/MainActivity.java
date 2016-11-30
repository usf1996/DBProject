package com.example.usf.dbproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usf.dbproject.Fragments.ProfileFragment;
import com.example.usf.dbproject.Login.LoginActivity;

/*import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //RequestQueue requestQueue;
    //String showUrl = "http://10.10.30.121/Android/showMembers.php"; //Ip address of your laptop, on your local network
    //allo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    try {
                        JSONArray members = response.getJSONArray("Family Members");

                        for (int i = 0; i < members.length(); i++) {

                            JSONObject member = members.getJSONObject(i);
                            String name = member.getString("name");
                            result.append(name + "\n");
                        }

                        ;
                    }catch(JSONException e){
                        e.printStackTrace();

                    }

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            requestQueue.add(jsonObjectRequest);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST,insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map <String,String> parameters = new HashMap<String,String>();
                        parameters.put("name" , name.getText().toString() );
                        return parameters;

                    }
                };
                requestQueue.add(request);

            }
        });*/


        Toolbar toolbar = (Toolbar) findViewById(R.id.appBarMain_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activityMain_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.activityMain_navHeader);
        navigationView.setNavigationItemSelectedListener(this);

        //Set profile screen as default screen on startup
        ProfileFragment profileFragment1 = new ProfileFragment();
        FragmentManager manager1 = getSupportFragmentManager();
        manager1.beginTransaction().replace(R.id.contentMain_frameLayout, profileFragment1).commit();
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
            super.onBackPressed();
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
