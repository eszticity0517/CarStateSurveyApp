package com.carstatesurveyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Lightning extends AppCompatActivity {

    private String[] perfectordonotworkoptions;
    private String[] perfercordonotworkornotincludedoptions;

    private Spinner sidelightsspinner;
    private Spinner dippedlightsspinner;
    private Spinner headlightspinner;
    private Spinner brakelightspinner;
    private Spinner reversingspinner;
    private Spinner turnsignalspinner;
    private Spinner foglightsspinner;

    private ArrayAdapter<String> sidelightsadapter;
    private ArrayAdapter<String> dippedlightsadapter;
    private ArrayAdapter<String> headlightadapter;
    private ArrayAdapter<String> brakelightadapter;
    private ArrayAdapter<String> reversingadapter;
    private ArrayAdapter<String> turnsignaladapter;
    private ArrayAdapter<String> foglightsadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightning);

        perfectordonotworkoptions = new String[]{
                "Perfect", "Do not work"
        };

        perfercordonotworkornotincludedoptions = new String[]{
                "Perfect", "Do not work", "Not included"
        };

        sidelightsspinner = (Spinner) findViewById(R.id.sidelightsspinner);
        dippedlightsspinner = (Spinner) findViewById(R.id.dippedlightsspinner);
        headlightspinner = (Spinner) findViewById(R.id.headlightspinner);
        brakelightspinner = (Spinner) findViewById(R.id.brakelightspinner);
        reversingspinner = (Spinner) findViewById(R.id.reversingspinner);
        turnsignalspinner = (Spinner) findViewById(R.id.turnsignalspinner);
        foglightsspinner = (Spinner) findViewById(R.id.foglightsspinner);

        sidelightsadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        sidelightsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sidelightsspinner.setAdapter(sidelightsadapter);

        dippedlightsadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        dippedlightsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dippedlightsspinner.setAdapter(dippedlightsadapter);

        headlightadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        headlightadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headlightspinner.setAdapter(headlightadapter);

        brakelightadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        brakelightadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brakelightspinner.setAdapter(brakelightadapter);


        reversingadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        reversingadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reversingspinner.setAdapter(reversingadapter);

        turnsignaladapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfectordonotworkoptions);
        turnsignaladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        turnsignalspinner.setAdapter(reversingadapter);

        foglightsadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, perfercordonotworkornotincludedoptions);
        foglightsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foglightsspinner.setAdapter(reversingadapter);

        Button nextbutton = (Button) findViewById(R.id.button4);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                sidelightsspinner = (Spinner) findViewById(R.id.sidelightsspinner);
                dippedlightsspinner = (Spinner) findViewById(R.id.dippedlightsspinner);
                headlightspinner = (Spinner) findViewById(R.id.headlightspinner);
                brakelightspinner = (Spinner) findViewById(R.id.brakelightspinner);
                reversingspinner = (Spinner) findViewById(R.id.reversingspinner);
                turnsignalspinner = (Spinner) findViewById(R.id.turnsignalspinner);
                foglightsspinner = (Spinner) findViewById(R.id.foglightsspinner);

                editor.putString("sidelights", sidelightsspinner.getSelectedItem().toString());
                editor.putString("dippedlights", dippedlightsspinner.getSelectedItem().toString());
                editor.putString("headlight", headlightspinner.getSelectedItem().toString());
                editor.putString("brakelight", brakelightspinner.getSelectedItem().toString());
                editor.putString("reversing", reversingspinner.getSelectedItem().toString());
                editor.putString("turnsignal", turnsignalspinner.getSelectedItem().toString());
                editor.putString("foglights", foglightsspinner.getSelectedItem().toString());

                editor.apply();

                Intent k = new Intent(Lightning.this, Lightning.class);
                startActivity(k);
            }
        });
    }
}
