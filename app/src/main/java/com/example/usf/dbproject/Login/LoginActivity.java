package com.example.usf.dbproject.Login;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.usf.dbproject.Entities.User;
import com.example.usf.dbproject.MainActivity;
import com.example.usf.dbproject.R;
import com.example.usf.dbproject.Requests.LoginRequest;


import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    public static User currentuser = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        final EditText etUsername = (EditText) findViewById(R.id.activityLogin_username);
        final EditText etPassword = (EditText) findViewById(R.id.activityLogin_password);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.activityLogin_registerLink);
        final Button bLogin = (Button) findViewById(R.id.activityLogin_loginButton);


        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();




                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                JSONObject info = jsonResponse.getJSONObject("info");
                                currentuser = new User (
                                        Integer.parseInt(info.getString("userID")),
                                        info.getString("username"),
                                        info.getString("passcode"),
                                        info.getString("email"),
                                        info.getString("firstName"),
                                        info.getString("lastName"),
                                        info.getString("dateOfBirth"),
                                        info.getString("dateCreated"),
                                        info.getString("gender").charAt(0)
                                );
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                LoginActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };




                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}


