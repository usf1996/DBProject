package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class MovieGenreRequest extends StringRequest {
    private static final String MOVIEGENRE_REQUEST_URL = "http://192.168.43.180/dbscript/getmoviegenre.php";
    private Map<String, String> params;

    public MovieGenreRequest(Response.Listener<String> listener) {
        super(Method.POST, MOVIEGENRE_REQUEST_URL, listener, null);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

