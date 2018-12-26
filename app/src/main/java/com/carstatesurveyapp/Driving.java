package com.carstatesurveyapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Driving extends AppCompatActivity {

    private Spinner enginesoundspinner;
    private Spinner doesitsmokewhenacceleratingspinner;
    private Spinner shiftgatespinner;
    private Spinner clutchspinner;
    private Spinner flywheelspinner;
    private Spinner automationchangeroperationspinner;
    private Spinner powersteeringspinner;
    private Spinner handbrakespinner;
    private Spinner suspensionconditionspinner;
    private Spinner brakeconditionspinner;
    private Spinner parkingradiocameraspinner;

    private ArrayAdapter<String> enginesoundadapter;
    private ArrayAdapter<String> doesitsmokewhenacceleratingadapter;
    private ArrayAdapter<String> shiftgateadapter;
    private ArrayAdapter<String> clutchadapter;
    private ArrayAdapter<String> flywheeladapter;
    private ArrayAdapter<String> automationchangeroperationadapter;
    private ArrayAdapter<String> powersteeringadapter;
    private ArrayAdapter<String> handbrakeadapter;
    private ArrayAdapter<String> suspensionconditionadapter;
    private ArrayAdapter<String> brakeconditionadapter;
    private ArrayAdapter<String> parkingradiocameraadapter;

    private String[] enginesoundoptions;
    private String[] doesitsmokewhenacceleratingoptions;
    private String[] shiftgateoptions;
    private String[] clutchoptions;
    private String[] flywheeloptions;
    private String[] automationchangeroperationoptions;
    private String[] powersteeringoptions;
    private String[] handbrakeoptions;
    private String[] suspensionconditionoptions;
    private String[] brakeconditionoptions;
    private String[] parkingradiocameraoptions;

    private RadioGroup radioGroup;

    private EditText thesourceofthelandinggearfailure;
    private EditText brakeerrorsource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);

        enginesoundoptions = new String[] {
            "Perfect", "Bad"
        };
        doesitsmokewhenacceleratingoptions= new String[] {
            "Yes", "No"
        };
        clutchoptions= new String[] {
                "Perfect", "Skids", "Incorrect"
        };
        flywheeloptions= new String[] {
                "Perfect", "Incorrect"
        };
        automationchangeroperationoptions= new String[] {
                "Perfect", "Incorrect"
        };
        powersteeringoptions= new String[] {
                "Perfect", "Incorrect"
        };
        handbrakeoptions= new String[] {
                "Perfect", "Incorrect"
        };
        suspensionconditionoptions= new String[] {
            "Perfect", "Incorrect"
        };
        brakeconditionoptions= new String[] {
            "Perfect", "Wavy / incorrect"
        };
        parkingradiocameraoptions = new String[] {
            "Perfect", "Works incorrectly", "Not included"
        };
        shiftgateoptions = new String[]{
            "Perfect", "Incorrect"
        };

        thesourceofthelandinggearfailure = (EditText) findViewById(R.id.landinggearfailurereasontext);
        brakeerrorsource = (EditText) findViewById(R.id.brakeerrorsourcetext);

        enginesoundspinner = (Spinner) findViewById(R.id.enginesoundspinner);
        doesitsmokewhenacceleratingspinner = (Spinner) findViewById(R.id.doesitsmokewhenacceleratingspinner);
        shiftgatespinner = (Spinner) findViewById(R.id.shiftgatespinner);
        clutchspinner = (Spinner) findViewById(R.id.clutchspinner);
        flywheelspinner = (Spinner) findViewById(R.id.flywheelspinner);
        automationchangeroperationspinner = (Spinner) findViewById(R.id.automationchangeroperationspinner);
        powersteeringspinner = (Spinner) findViewById(R.id.powerstreeringspinner);
        handbrakespinner = (Spinner) findViewById(R.id.handbrakespinner);
        suspensionconditionspinner = (Spinner) findViewById(R.id.suspensionconditionspinner);
        brakeconditionspinner = (Spinner) findViewById(R.id.brakeconditionspinner);
        parkingradiocameraspinner = (Spinner) findViewById(R.id.parkingradiocameraspinner);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.check(R.id.nothing);

        enginesoundadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, enginesoundoptions);
        enginesoundadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enginesoundspinner.setAdapter(enginesoundadapter);

        doesitsmokewhenacceleratingadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, doesitsmokewhenacceleratingoptions);
        doesitsmokewhenacceleratingadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doesitsmokewhenacceleratingspinner.setAdapter(doesitsmokewhenacceleratingadapter);

        shiftgateadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, shiftgateoptions);
        shiftgateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shiftgatespinner.setAdapter(shiftgateadapter);

        clutchadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, clutchoptions);
        clutchadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clutchspinner.setAdapter(clutchadapter);

        flywheeladapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, flywheeloptions);
        flywheeladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flywheelspinner.setAdapter(flywheeladapter);

        automationchangeroperationadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, automationchangeroperationoptions);
        automationchangeroperationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        automationchangeroperationspinner.setAdapter(automationchangeroperationadapter);

        powersteeringadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, powersteeringoptions);
        powersteeringadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        powersteeringspinner.setAdapter(powersteeringadapter);

        handbrakeadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, handbrakeoptions);
        handbrakeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        handbrakespinner.setAdapter(handbrakeadapter);

        suspensionconditionadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, suspensionconditionoptions);
        suspensionconditionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        suspensionconditionspinner.setAdapter(suspensionconditionadapter);

        brakeconditionadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, brakeconditionoptions);
        brakeconditionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brakeconditionspinner.setAdapter(brakeconditionadapter);

        parkingradiocameraadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, parkingradiocameraoptions);
        parkingradiocameraadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkingradiocameraspinner.setAdapter(parkingradiocameraadapter);

        Button nextbutton = findViewById(R.id.button4);

        nextbutton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferenceName", 0);
                SharedPreferences.Editor editor = settings.edit();

                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);
                String text = radioButton.getText().toString();
                String text2 = thesourceofthelandinggearfailure.getText().toString();
                String text3 = brakeerrorsource.getText().toString();

                editor.putString("thesourceofthelandinggearfailure", text2 );
                editor.putString("errorsinextensionsduringdrive", text3);

                editor.putString("errorsinextensionsduringdrive", text);

                editor.putString("enginesound", enginesoundspinner.getSelectedItem().toString());
                editor.putString("doesitsmokewhenaccelerating", doesitsmokewhenacceleratingspinner.getSelectedItem().toString());
                editor.putString("shiftgate", shiftgatespinner.getSelectedItem().toString());
                editor.putString("clutch", clutchspinner.getSelectedItem().toString());
                editor.putString("flywheel", flywheelspinner.getSelectedItem().toString());
                editor.putString("automationchangeroperation", automationchangeroperationspinner.getSelectedItem().toString());
                editor.putString("powersteering", powersteeringspinner.getSelectedItem().toString());
                editor.putString("handbrake", handbrakespinner.getSelectedItem().toString());
                editor.putString("suspensioncondition", suspensionconditionspinner.getSelectedItem().toString());
                editor.putString("brakecondition", brakeconditionspinner.getSelectedItem().toString());
                editor.putString("parkingradiocamera", parkingradiocameraspinner.getSelectedItem().toString());

                editor.apply();

                Intent k = new Intent(Driving.this, Lightning.class);
                startActivity(k);
            }
        });


    }
}
