package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.MainActivity;


public class SearchMovieRequest extends StringRequest {
    private static final String SearchMovie_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getallmovies.php";

    public SearchMovieRequest(Response.Listener<String> listener) {
        super(SearchMovie_REQUEST_URL, listener, null);
    }
}

