package com.authentification.khalidbaba.authentification;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by khalidbaba on 28/01/2018.
 */


public class MainActivity extends Activity {




    EditText Email;
    Button Signin;

    String _email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Email = (EditText) findViewById(R.id.email);
        Signin = (Button) findViewById(R.id.btnLogin);




        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _email = Email.getText().toString();

                //TODO 5 : uses OKHttp to send GET request with email and password and check of the users is exist in the db

                //TODO 6 : Create Intent and send email content to the welcome_activity


            }
        });





    }
}
