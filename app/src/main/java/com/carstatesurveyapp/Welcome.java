package com.carstatesurveyapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    private TextView welcometext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button startsurvebutton = findViewById(R.id.button4);
        startsurvebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent k = new Intent(Welcome.this, GeneralInfo.class);
                startActivity(k);
            }
        });

        SharedPreferences prefs = getSharedPreferences("PreferencesName", MODE_PRIVATE);
        String myInt = prefs.getString("myInt", "0"); // 0 is default

        welcometext = (TextView) findViewById(R.id.welcometext);
        welcometext.setText("Welcome " + myInt + "!");
    }
}
