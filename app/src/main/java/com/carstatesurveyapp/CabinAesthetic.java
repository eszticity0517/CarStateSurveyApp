package com.carstatesurveyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CabinAesthetic extends AppCompatActivity {

    private ArrayAdapter<String> needleatherpaintadapter;
    private ArrayAdapter<String> cabinsmelladapter;
    private ArrayAdapter<String> trimsandleatheradapter;
    private ArrayAdapter<String> carpetsadapter;
    private ArrayAdapter<String> changeoverbuttonadapter;
    private ArrayAdapter<String> controlstatusadapter;
    private ArrayAdapter<String> interiorrearviewadapter;
    private ArrayAdapter<String> headrestsadapter;
    private ArrayAdapter<String> trunkmatadapter;
    private ArrayAdapter<String> hatrackadapter;
    private ArrayAdapter<String> handrailsadapter;
    private ArrayAdapter<String> steeringstateadapter;

    private Spinner needleatherpaintspinner;
    private Spinner cabinsmellspinner;
    private Spinner trimsandleatherspinner;
    private Spinner carpetspinner;
    private Spinner changeoverbuttonspinner;
    private Spinner controlstatusespinner;
    private Spinner interiorrearviewspinner;
    private Spinner headrestspinner;
    private Spinner handrailspinner;
    private Spinner steeringstatespinner;

    private String[] needleatherpaints;
    private String[] cabinsmells;
    private String[] trimsandleathers;
    private String[] carpetsandchangeoverbuttons;
    private String[] controlstatuses;
    private String[] interiorrearviews;
    private String[] headrests;
    private String[] handrails;
    private String[] steeringstates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabin_aesthetic);

        Button nextButton = (Button) findViewById(R.id.button4);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String cabinsmell = cabinsmellspinner.getSelectedItem().toString();
                String carpet = carpetspinner.getSelectedItem().toString();
                String changeoverbutton = changeoverbuttonspinner.getSelectedItem().toString();
                String controlstatus = controlstatusespinner.getSelectedItem().toString();
                String handrail = handrailspinner.getSelectedItem().toString();
                String headrest = headrestspinner.getSelectedItem().toString();
                String interiorrearview = interiorrearviewspinner.getSelectedItem().toString();
                String needleatherpaint = needleatherpaintspinner.getSelectedItem().toString();
                String steeringstate = steeringstatespinner.getSelectedItem().toString();
                String trimsandleather = trimsandleatherspinner.getSelectedItem().toString();

                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("cabinsmell", cabinsmell);
                editor.putString("carpet", carpet);
                editor.putString("changeoverbutton", changeoverbutton);
                editor.putString("controlstatus", controlstatus);
                editor.putString("handrail", handrail);
                editor.putString("headrest", headrest);
                editor.putString("interiorrearview", interiorrearview);
                editor.putString("needleatherpaint", needleatherpaint);
                editor.putString("steeringstate", steeringstate);
                editor.putString("trimsandleather", trimsandleather);

                editor.apply();

                Intent k = new Intent(CabinAesthetic.this, CabinTechnical.class);
                startActivity(k);
            }
        });

        // This info will come from an API function.
        needleatherpaints = new String[] {
                "Yes", "No"
        };

        cabinsmells = new String[] {
                "Pleasant", "Unpleasant"
        };

        trimsandleathers = new String[] {
                "Perfect", "Has to be repaired", "Carpet cleaning needed", "Leather care needed"
        };

        carpetsandchangeoverbuttons = new String[] {
                "Perfect", "New needed/ deficient"
        };

        controlstatuses = new String[] {
                "Perfect", "To be repaired", "Washing is needed"
        };

        interiorrearviews = new String[] {
                "Perfect", "To be repaired", "Missing"
        };

        headrests = new String[] {
                "There are", "Missing"
        };

        handrails = new String[] {
                "There is", "Missing", "Not included"
        };

        steeringstates = new String[] {
                "Appropriate", "Has to be repaired"
        };

        needleatherpaintspinner = (Spinner) findViewById(R.id.needleatherpaintspinner);

        needleatherpaintadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, needleatherpaints);
        needleatherpaintadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        needleatherpaintspinner.setAdapter(needleatherpaintadapter);

        cabinsmellspinner = (Spinner) findViewById(R.id.cabinsmellspinner);

        cabinsmelladapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cabinsmells);
        cabinsmelladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cabinsmellspinner.setAdapter(cabinsmelladapter);

        trimsandleatherspinner = (Spinner) findViewById(R.id.trimsandleatherspinner);

        trimsandleatheradapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, trimsandleathers);
        cabinsmelladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        trimsandleatherspinner.setAdapter(trimsandleatheradapter);

        carpetspinner = (Spinner) findViewById(R.id.carpetsspinner);

        carpetsadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, carpetsandchangeoverbuttons);
        carpetsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carpetspinner.setAdapter(carpetsadapter);

        changeoverbuttonspinner = (Spinner) findViewById(R.id.changeoverbuttonspinner);

        changeoverbuttonadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, carpetsandchangeoverbuttons);
        changeoverbuttonadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        changeoverbuttonspinner.setAdapter(changeoverbuttonadapter);

        controlstatusespinner = (Spinner) findViewById(R.id.controlstatusspinner);

        controlstatusadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, controlstatuses);
        controlstatusadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        controlstatusespinner.setAdapter(controlstatusadapter);

        interiorrearviewspinner = (Spinner) findViewById(R.id.interiorrearviewspinner);
        interiorrearviewadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, interiorrearviews);
        interiorrearviewadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        interiorrearviewspinner.setAdapter(interiorrearviewadapter);

        headrestspinner = (Spinner) findViewById(R.id.headrestsspinner);
        headrestsadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, headrests);
        headrestsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        headrestspinner.setAdapter(headrestsadapter);

        handrailspinner = (Spinner) findViewById(R.id.handrailsspinner);
        handrailsadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, handrails);
        handrailsadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        handrailspinner.setAdapter(handrailsadapter);

        steeringstatespinner = (Spinner) findViewById(R.id.steeringstatespinner);
        steeringstateadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, steeringstates);
        steeringstateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        steeringstatespinner.setAdapter(steeringstateadapter);
    }
}
