package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.MainActivity;

import java.util.HashMap;
import java.util.Map;


public class MovieGenreRequest extends StringRequest {
    private static final String MOVIEGENRE_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getmoviegenre.php";

    public MovieGenreRequest(Response.Listener<String> listener) {
        super(MOVIEGENRE_REQUEST_URL, listener, null);
    }

}

