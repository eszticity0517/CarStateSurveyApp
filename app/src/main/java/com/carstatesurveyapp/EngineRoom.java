package com.carstatesurveyapp;

import android.content.Intent;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EngineRoom extends AppCompatActivity {

    private Spinner engineroomcleannessspinner;
    private Spinner oilconsinstencyspinner;
    private Spinner coolingwaterspinner;
    private Spinner waterleakingspinner;
    private Spinner engineroomcoverspinner;

    private String[] engineroomcleannesses;
    private String[] oilconsistencies;
    private String[] coolingwaters;
    private String[] waterleakings;
    private String[] engineroomcovers;

    private ArrayAdapter<String> engineroomcleannessadapter;
    private ArrayAdapter<String> oilconsinstencyadapter;
    private ArrayAdapter<String> coolingwateradapter;
    private ArrayAdapter<String> waterleakingadapter;
    private ArrayAdapter<String> engineroomcoveradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engine_room);

        Button nextbutton = findViewById(R.id.button4);
        nextbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent k = new Intent(EngineRoom.this, CabinAesthetic.class);
                startActivity(k);
            }
        });

        // This info will come from an API function.
        engineroomcleannesses = new String[] {
                "Perfect", "Should be cleansed"
        };

        oilconsistencies = new String[] {
            "Perfect", "Not very good", "Oil replacement needed"
        };

        coolingwaters = new String[] {
            "Appropriate", "Inappropriate"
        };

        waterleakings = new String[] {
            "There is", "There is not"
        };

        engineroomcovers = new String[]{
            "There is", "Missing / broken", "Not included"
        };

        engineroomcleannessspinner = (Spinner) findViewById(R.id.engineroomcleannessspinner);

        engineroomcleannessadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, engineroomcleannesses);
        engineroomcleannessadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        engineroomcleannessspinner.setAdapter(engineroomcleannessadapter);

        oilconsinstencyspinner = (Spinner) findViewById(R.id.oilconsinstencyspinner);

        oilconsinstencyadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, oilconsistencies);
        oilconsinstencyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        oilconsinstencyspinner.setAdapter(oilconsinstencyadapter);

        coolingwaterspinner = (Spinner) findViewById(R.id.coolingwaterspinner);

        coolingwateradapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, coolingwaters);
        coolingwateradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coolingwaterspinner.setAdapter(coolingwateradapter);

        waterleakingspinner = (Spinner) findViewById(R.id.waterleakingspinner);

        waterleakingadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, waterleakings);
        waterleakingadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        waterleakingspinner.setAdapter(waterleakingadapter);

        engineroomcoverspinner = (Spinner) findViewById(R.id.engineroomcoverspinner);

        engineroomcoveradapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, engineroomcovers);
        engineroomcoveradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        engineroomcoverspinner.setAdapter(engineroomcoveradapter);
    }
}
