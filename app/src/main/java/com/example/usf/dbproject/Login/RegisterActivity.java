package com.example.usf.dbproject.Login;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.usf.dbproject.DatePickerFragment;
import com.example.usf.dbproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    char gender;
    DialogFragment datePickerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText et_fname = (EditText) findViewById(R.id.activityRegister_fname);
        final EditText et_lname = (EditText) findViewById(R.id.activityRegister_lname);
        final EditText et_username = (EditText) findViewById(R.id.activityRegister_username);
        final EditText et_email = (EditText) findViewById(R.id.activityRegister_email);
        final EditText et_password = (EditText) findViewById(R.id.activityRegister_password);
        Button bt_reg = (Button) findViewById(R.id.activityRegister_button);

        bt_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = et_fname.getText().toString();
                final String lname = et_lname.getText().toString();
                final String username = et_username.getText().toString();
                final String email = et_email.getText().toString();
                final String password = et_password.getText().toString();
                final Date date = ((DatePickerFragment) datePickerFragment).getDate();
                date.setYear(date.getYear() - 1900);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                final String sqldate = sdf.format(date);
                Log.d("taag", "onClick: " + sqldate);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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

                RegisterRequest registerRequest = new RegisterRequest(fname, lname, username, email,
                        password, gender, sqldate, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }

    public void showDatePickerDialog(View v) {
        datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.activityRegister_male:
                if (checked)
                    gender = 'M';
                    break;
            case R.id.activityRegister_female:
                if (checked)
                    gender = 'F';
                    break;
        }
    }

}