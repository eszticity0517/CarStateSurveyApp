package com.carstatesurveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class Welcome extends AppCompatActivity {

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
    }
}
