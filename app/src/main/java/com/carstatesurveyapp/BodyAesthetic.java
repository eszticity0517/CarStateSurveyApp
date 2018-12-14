package com.carstatesurveyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class BodyAesthetic extends AppCompatActivity {

    private ArrayAdapter<String> polishadapter;
    private ArrayAdapter<String> rustyadapter;
    private ArrayAdapter<String> windscreenadapter;
    private ArrayAdapter<String> lampadapter;
    private ArrayAdapter<String> headlightwasheradapter;
    private ArrayAdapter<String> windscreenwiperadapter;
    private ArrayAdapter<String> antennaadapters;
    private ArrayAdapter<String> boltsandwheelguardadapter;
    private ArrayAdapter<String> carjackadapter;

    private String[] polishes;
    private String[] rusties;
    private String[] windscreens;
    private String[] lamps;
    private String[] headlightwashers;
    private String[] windscreenwipers;
    private String[] antennas;
    private String[] carjacks;

    private Spinner polishspinner;
    private Spinner rustyspinner;
    private Spinner windscreenspinner;
    private Spinner lampsspinner;
    private Spinner headlightwasherspinner;
    private Spinner windscreenwiperspinner;
    private Spinner antennaspinner;
    private Spinner carjackspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_aesthetic);

        Button nextbutton = findViewById(R.id.button4);

        nextbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // First get selected values from spinner
                String polish = polishspinner.getSelectedItem().toString();
                String isthecarrusty = rustyspinner.getSelectedItem().toString();
                String windscreen = windscreenspinner.getSelectedItem().toString();
                String lamps = lampsspinner.getSelectedItem().toString();
                String headlightwashers = headlightwasherspinner.getSelectedItem().toString();
                String windscreenwiper = windscreenwiperspinner.getSelectedItem().toString();
                String antenna = antennaspinner.getSelectedItem().toString();
                String carjack = carjackspinner.getSelectedItem().toString();

                // After we get data from TextViews
                TextView tirebrandtext = (TextView) findViewById(R.id.tirebrandtext);
                String tirebrand = tirebrandtext.getText().toString();

                TextView sparetirebrandtext = (TextView) findViewById(R.id.sparetirebrandtext);
                String sparetirebrand = sparetirebrandtext.getText().toString();

                TextView tireconditiontext = (TextView) findViewById(R.id.tireconditiontext);
                String tirecondition = tireconditiontext.getText().toString();

                // Save data
                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                RadioGroup boltsandwheelguardradiobutton = (RadioGroup) findViewById(R.id.radiogroup);
                int radioButtonID = boltsandwheelguardradiobutton.getCheckedRadioButtonId();
                RadioButton  radioButton = boltsandwheelguardradiobutton.findViewById(radioButtonID);
                String text = radioButton.getText().toString();

                editor.putString("polish", polish);
                editor.putString("isthecarrusty", isthecarrusty);
                editor.putString("windscreen", windscreen);
                editor.putString("lamps", lamps);
                editor.putString("headlightwashers", headlightwashers);
                editor.putString("windscreenwiper", windscreenwiper);
                editor.putString("antenna", antenna);
                editor.putString("tirebrand", tirebrand);
                editor.putString("sparetirebrand", sparetirebrand);
                editor.putString("carjack", carjack);
                editor.putString("tirecondition", tirecondition);
                editor.putString("boltsandwheelguard", text);

                editor.apply();

                Intent k = new Intent(BodyAesthetic.this, PaintThickness.class);
                startActivity(k);
            }
        });

        // This info will come from an API function.
        polishes = new String[] {
                "Perfect", "Should be polished"
        };

        rusties = new String[] {
                "Yes", "No"
        };

        windscreens = new String[] {
                "Perfect", "Should be replaced"
        };

        lamps = new String[] {
                "Perfect", "Should be polished", "Should be replaced"
        };

        headlightwashers = new String[]{
                "Not included", "Perfect", "Malfunctioning"
        };

        windscreenwipers = new String[] {
                "In good condition", "Should be replaced", "Missing"
        };

        antennas = new String[] {
                "Has / equipped", "Missing / should be ordered"
        };

        carjacks = new String[]{
                "Is there", "Missing", "Not included"
        };

        polishspinner = (Spinner) findViewById(R.id.polishspinner);

        polishadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, polishes);
        polishadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        polishspinner.setAdapter(polishadapter);

        rustyspinner = (Spinner) findViewById(R.id.isthecarrustyspinner);

        rustyadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, rusties);
        rustyadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rustyspinner.setAdapter(rustyadapter);

        windscreenspinner = (Spinner) findViewById(R.id.windscreenspinner);

        windscreenadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, windscreens);
        windscreenadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        windscreenspinner.setAdapter(windscreenadapter);

        lampsspinner = (Spinner) findViewById(R.id.lampsspinner);

        lampadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lamps);
        lampadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lampsspinner.setAdapter(lampadapter);

        headlightwasherspinner = (Spinner) findViewById(R.id.headlightwashersspinner);

        headlightwasheradapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, headlightwashers);
        headlightwasheradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headlightwasherspinner.setAdapter(headlightwasheradapter);

        windscreenwiperspinner = (Spinner) findViewById(R.id.windscreenwiperspinner);

        windscreenwiperadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, windscreenwipers);
        headlightwasheradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        windscreenwiperspinner.setAdapter(windscreenwiperadapter);

        antennaspinner = (Spinner) findViewById(R.id.antennaspinner);

        antennaadapters = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, antennas);
        antennaadapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        antennaspinner.setAdapter(windscreenwiperadapter);

        carjackspinner = (Spinner) findViewById(R.id.carjackspinner);

        carjackadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, carjacks);
        carjackadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carjackspinner.setAdapter(carjackadapter);
    }
}
