package com.authentification.khalidbaba.authentification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by khalidbaba on 28/01/2018.
 */

public class WelcomeActivity extends Activity {

    //TODO : Declare all variables (TextView, String)

    TextView Email;
    String _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //TODO 7 : Instantiate all objects

        Email = (TextView) findViewById(R.id.email);


        //TODO 8 : Get the intent content and show the Email in the TextView

        Intent i = getIntent();
        _email = i.getStringExtra("Email");

        Email.setText(_email);

    }
}
