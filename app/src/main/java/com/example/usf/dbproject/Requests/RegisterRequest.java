package com.example.usf.dbproject.Requests;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://192.168.0.100/dbscript/register.php";
    private Map<String, String> params;

    public RegisterRequest (String fname, String  lname, String  username, String  email, String  password,
                            char gender, String date, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstName", fname);
        params.put("lastName", lname);
        params.put("username", username);
        params.put("email", email);
        params.put("passcode", password);
        params.put("gender", gender + "");
        params.put("date", date);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
