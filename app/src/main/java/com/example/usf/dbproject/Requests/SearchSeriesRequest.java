package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.MainActivity;

import java.util.Map;


public class SearchSeriesRequest extends StringRequest {
    private static final String Searchseries_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getallseries.php";

    public SearchSeriesRequest(Response.Listener<String> listener) {
        super(Searchseries_REQUEST_URL, listener, null);
    }

}

