package com.authentification.khalidbaba.authentification;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by khalidbaba on 28/01/2018.
 */


public class MainActivity extends Activity {



    private static final String TAG = RegisterActivity.class.getSimpleName();
    public String postUrl = "http://10.1.22.56:8888/project/v1/register";

    EditText Email;
    Button Signin;
    TextView btnRegister;
    String _email;
    String _password;
    EditText Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Email = (EditText) findViewById(R.id.email);
        Signin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (TextView) findViewById(R.id.btnLinkToRegisterScreen);
        Password=(EditText)findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);

            }
        });
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _email = Email.getText().toString();
                _password = Password.getText().toString();
                login(_email, _password);

            }
        });

        //TODO 2 : handle click listener in signIn button and get values from the editText


        //TODO 3 : uses Volley to get all the data(Name, Email, Password) in the data bases ans show Toast for return values

        //TODO 4 : if everything went right redirect the user to the welcome interface with name and email values





    }


    /**
     * function to verify signup details in mysql db
     * */
    private void login(final String email, final String password) {
        String tag_string_req = "req_login";

        StringRequest strReq = new StringRequest(Request.Method.POST,
                postUrl, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // Launch main activity
                        Intent intent = new Intent(MainActivity.this,
                                WelcomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("message");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}
