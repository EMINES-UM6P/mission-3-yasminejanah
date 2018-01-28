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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by khalidbaba on 28/01/2018.
 */


public class MainActivity extends Activity {




    EditText Email;
    Button Signin;
    TextView btnRegister;
    String _email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Email = (EditText) findViewById(R.id.email);
        Signin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (TextView) findViewById(R.id.btnLinkToRegisterScreen);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

        //TODO 2 : handle click listener in signIn button and get values from the editText


        //TODO 3 : uses Volley to get all the data(Name, Email, Password) in the data bases ans show Toast for return values

        //TODO 4 : if everything went right redirect the user to the welcome interface with name and email values





    }
}
