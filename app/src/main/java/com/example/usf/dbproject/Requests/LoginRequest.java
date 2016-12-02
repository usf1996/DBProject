package com.example.usf.dbproject.Requests;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.usf.dbproject.MainActivity;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://" + MainActivity.IP + "/dbscript/login.php";
    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        Log.i("aaa", "LoginRequest: " + LOGIN_REQUEST_URL);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
