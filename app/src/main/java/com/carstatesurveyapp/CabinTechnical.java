package com.carstatesurveyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class CabinTechnical extends AppCompatActivity {

    private Spinner remorecontrolslocksspinner;
    private Spinner audiosystemspinner;
    private Spinner clockgroupspinner;
    private Spinner hornspinner;
    private Spinner electricwindowsspinner;
    private Spinner electricmirroradjustmentspinner;
    private Spinner swingswitchesmultiswitchesspinner;
    private Spinner navigationsystemspinner;
    private Spinner sunroofspinner;

    private RadioGroup radioGroup;
    private TextView whatisthecode;

    private ArrayAdapter<String> remorecontrolslockadapter;
    private ArrayAdapter<String> audiosystemadapter;
    private ArrayAdapter<String> clockgroupadapter;
    private ArrayAdapter<String> hornadapter;
    private ArrayAdapter<String> electricwindowsadapter;
    private ArrayAdapter<String> electricmirroradjustmentadapter;
    private ArrayAdapter<String> swingswitchesmultiswitchesadapter;
    private ArrayAdapter<String> navigationsystemadapter;
    private ArrayAdapter<String> sunroofadapter;

    private String[] remorecontrolslocks;
    private String[] audiosystems;
    private String[] clockgroups;
    private String[] horns;
    private String[] electricwindowses;
    private String[] electricmirroradjustments;
    private String[] swingswitchesmultiswitchess;
    private String[] navigationsystems;
    private String[] sunroofs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabin_technical);

        remorecontrolslocksspinner = (Spinner) findViewById(R.id.remorecontrolslocksspinner);
        audiosystemspinner = (Spinner) findViewById(R.id.audiosystemspinner);
        clockgroupspinner = (Spinner) findViewById(R.id.clockgroupspinner);
        hornspinner = (Spinner) findViewById(R.id.hornspinner);
        electricwindowsspinner = (Spinner) findViewById(R.id.electricwindowsspinner);
        electricmirroradjustmentspinner = (Spinner) findViewById(R.id.electricmirroradjustmentspinner);
        swingswitchesmultiswitchesspinner = (Spinner) findViewById(R.id.swingswitchesmultiswitchesspinner);
        navigationsystemspinner = (Spinner) findViewById(R.id.navigationsystemspinner);
        sunroofspinner = (Spinner) findViewById(R.id.sunroofspinner);

        radioGroup = (RadioGroup) findViewById(R.id.seatadjustmentgroup);
        radioGroup.check(R.id.workseveriwhere);
        whatisthecode = (TextView) findViewById(R.id.whatisthecodetext);

        remorecontrolslocks = new String[] {
                "Works correctly", "Works incorrectly", "One of them works"
        };

        audiosystems = new String[] {
                "Works correctly", "Works incorrectly", "Requires code"
        };

        clockgroups = new String[] {
                "Works correctly", "Does not work"
        };

        horns = new String[] {
                "Works correctly", "Works incorrectly"
        };

        electricwindowses = new String[] {
                "Works correctly", "Works incorrectly", "Not electric"
        };

        electricmirroradjustments = new String[] {
                "Works correctly", "Works incorrectly", "Not electric"
        };

        swingswitchesmultiswitchess = new String[] {
                "Works correctly", "Works incorrectly"
        };

        navigationsystems = new String[] {
                "Works correctly", "Works correctly but requires CD", "Does not work", "Not included"
        };

        sunroofs = new String[] {
                "Works correctly", "Works incorrectly", "Leaked", "Not included", "Should be serviced"
        };

        remorecontrolslockadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, remorecontrolslocks);
        remorecontrolslockadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        remorecontrolslocksspinner.setAdapter(remorecontrolslockadapter);

        audiosystemadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, audiosystems);
        audiosystemadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        audiosystemspinner.setAdapter(audiosystemadapter);

        clockgroupadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, clockgroups);
        clockgroupadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clockgroupspinner.setAdapter(clockgroupadapter);

        hornadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, horns);
        hornadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hornspinner.setAdapter(hornadapter);

        electricwindowsadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, electricwindowses);
        electricwindowsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electricwindowsspinner.setAdapter(electricwindowsadapter);

        electricmirroradjustmentadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, electricmirroradjustments);
        electricmirroradjustmentadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electricmirroradjustmentspinner.setAdapter(electricmirroradjustmentadapter);

        swingswitchesmultiswitchesadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, swingswitchesmultiswitchess);
        swingswitchesmultiswitchesadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        swingswitchesmultiswitchesspinner.setAdapter(swingswitchesmultiswitchesadapter);

        navigationsystemadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, navigationsystems);
        navigationsystemadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        navigationsystemspinner.setAdapter(navigationsystemadapter);

        sunroofadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sunroofs);
        sunroofadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sunroofspinner.setAdapter(sunroofadapter);

        Button nextbutton = (Button) findViewById(R.id.button4);

        nextbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton  radioButton = radioGroup.findViewById(radioButtonID);
                String text = radioButton.getText().toString();

                String whatisthecodetext = whatisthecode.getText().toString();

                String remorecontrolslocks = remorecontrolslocksspinner.getSelectedItem().toString();
                String audiosystem = audiosystemspinner.getSelectedItem().toString();
                String clockgroup = clockgroupspinner.getSelectedItem().toString();
                String horn = hornspinner.getSelectedItem().toString();
                String electricwindows = electricwindowsspinner.getSelectedItem().toString();
                String electricmirroradjustment = electricmirroradjustmentspinner.getSelectedItem().toString();
                String swingswitchesmultiswitches = swingswitchesmultiswitchesspinner.getSelectedItem().toString();
                String navigationsystem = navigationsystemspinner.getSelectedItem().toString();
                String sunroof = sunroofspinner.getSelectedItem().toString();

                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("remorecontrolslocks", remorecontrolslocks);
                editor.putString("audiosystem", audiosystem);
                editor.putString("whatisthecode", whatisthecodetext);
                editor.putString("clockgroup", clockgroup);
                editor.putString("horn", horn);
                editor.putString("electricwindows", electricwindows);
                editor.putString("electricmirroradjustment", electricmirroradjustment);
                editor.putString("swingswitchesmultiswitches", swingswitchesmultiswitches);
                editor.putString("navigationsystem", navigationsystem);
                editor.putString("sunroof", sunroof);
                editor.putString("seatadjustment", text);

                editor.apply();

                Intent k = new Intent(CabinTechnical.this, Locally.class);
                startActivity(k);
            }
        });
    }
}
