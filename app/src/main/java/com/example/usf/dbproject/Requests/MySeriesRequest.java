package com.example.usf.dbproject.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.Login.LoginActivity;
import com.example.usf.dbproject.MainActivity;

import java.util.HashMap;
import java.util.Map;


public class MySeriesRequest extends StringRequest {
    private static final String SearchSeries_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/getmyseries.php";
    private Map<String, String> params;

    public MySeriesRequest(Response.Listener<String> listener) {
        super(Method.POST, SearchSeries_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("userID", LoginActivity.currentuser.getUserID()+"");

    }


    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


