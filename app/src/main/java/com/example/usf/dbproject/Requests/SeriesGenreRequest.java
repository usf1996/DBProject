package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.MainActivity;


public class SeriesGenreRequest extends StringRequest {
    private static final String SERIESGENRE_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getseriesgenre.php";

    public SeriesGenreRequest(Response.Listener<String> listener) {
        super(SERIESGENRE_REQUEST_URL, listener, null);
    }

}

