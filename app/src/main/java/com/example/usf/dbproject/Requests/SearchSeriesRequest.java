package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;


public class SearchSeriesRequest extends StringRequest {
    private static final String Searchseries_REQUEST_URL = "http://192.168.0.100/dbscript/getallseries.php";

    public SearchSeriesRequest(Response.Listener<String> listener) {
        super(Searchseries_REQUEST_URL, listener, null);
    }

}

