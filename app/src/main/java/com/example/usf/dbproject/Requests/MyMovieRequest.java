package com.example.usf.dbproject.Requests;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.Login.LoginActivity;
import com.example.usf.dbproject.MainActivity;

import java.util.HashMap;
import java.util.Map;


public class MyMovieRequest extends StringRequest {
    private static final String SearchMovie_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getmymovies.php";
    private Map<String, String> params;

    public MyMovieRequest(Response.Listener<String> listener) {
        super(Method.POST, SearchMovie_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("userID", LoginActivity.currentuser.getUserID()+"");

    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


