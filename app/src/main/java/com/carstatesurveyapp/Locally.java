package com.carstatesurveyapp;

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

public class Locally extends AppCompatActivity {

    private Spinner doesitstartspinner;
    private Spinner istheaccumulatorokspinner;
    private Spinner istheengineflawlessspinner;
    private Spinner fuelspinner;
    private Spinner fuellevelspinner;
    private Spinner changertypespinner;
    private Spinner doestheairblowworkspinner;
    private Spinner doesthecompressorturnonspinner;
    private Spinner heatingspinner;

    private String[] doesitstartoptions;
    private String[] istheaccumulatorokoptions;
    private String[] istheengineflawlessoptions;
    private String[] fueloptions;
    private String[] fuelleveloptions;
    private String[] changertypeoptions;
    private String[] doestheairblowworkoptions;
    private String[] doesthecompressorturnonoptions;
    private String[] heatingoptions;

    private ArrayAdapter<String> doesitstartadapter;
    private ArrayAdapter<String> istheengineflawlessadapter;
    private ArrayAdapter<String> istheaccumulatorokadapter;
    private ArrayAdapter<String> fueladapter;
    private ArrayAdapter<String> fuelleveladapter;
    private ArrayAdapter<String> changertypeadapter;
    private ArrayAdapter<String> doestheairblowworkadapter;
    private ArrayAdapter<String> doesthecompressorturnonadapter;
    private ArrayAdapter<String> heatingadapter;

    private RadioGroup radioGroup;
    private EditText whatistheproblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locally);

        doesitstartoptions = new String[]{
                "Yes", "No"
        };

        istheaccumulatorokoptions = new String[]{
                "Yes", "No"
        };

        istheengineflawlessoptions = new String[]{
                "Yes", "No"
        };

        fueloptions = new String[]{
                "Petrol", "Diesel", "Hybrid", "Electric"
        };

        fuelleveloptions = new String[]{
                "Sufficient", "Should be refueled"
        };

        changertypeoptions = new String[] {
                "Automatic", "Manual"
        };

        doestheairblowworkoptions = new String[]{
                "Yes", "No"
        };

        doesthecompressorturnonoptions = new String[]{
                "Yes", "No"
        };

        heatingoptions = new String[]{
                "Works", "Does not work"
        };

        doesitstartspinner = (Spinner) findViewById(R.id.doesitstartspinner);
        istheaccumulatorokspinner = (Spinner) findViewById(R.id.istheaccumulatorokspinner);
        istheengineflawlessspinner = (Spinner) findViewById(R.id.istheengineflawlessspinner);
        fuelspinner = (Spinner) findViewById(R.id.fuelspinner);
        fuellevelspinner = (Spinner) findViewById(R.id.fuellevelspinner);
        changertypespinner = (Spinner) findViewById(R.id.changertypespinner);
        doestheairblowworkspinner = (Spinner) findViewById(R.id.doestheairblowworkspinner);
        doesthecompressorturnonspinner = (Spinner) findViewById(R.id.doesthecompressorturnonspinner);
        heatingspinner = (Spinner) findViewById(R.id.heatingspinner);


        doesitstartadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, doesitstartoptions);
        doesitstartadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doesitstartspinner.setAdapter(doesitstartadapter);

        istheaccumulatorokadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, istheaccumulatorokoptions);
        istheaccumulatorokadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        istheaccumulatorokspinner.setAdapter(istheaccumulatorokadapter);

        istheengineflawlessadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, istheengineflawlessoptions);
        istheengineflawlessadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        istheengineflawlessspinner.setAdapter(istheengineflawlessadapter);

        fueladapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fueloptions);
        fueladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelspinner.setAdapter(fueladapter);

        fuelleveladapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fuelleveloptions);
        fuelleveladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuellevelspinner.setAdapter(fuelleveladapter);

        changertypeadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, changertypeoptions);
        changertypeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        changertypespinner.setAdapter(changertypeadapter);

        doestheairblowworkadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, doestheairblowworkoptions);
        doestheairblowworkadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doestheairblowworkspinner.setAdapter(doestheairblowworkadapter);

        doesthecompressorturnonadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, doesthecompressorturnonoptions);
        doesthecompressorturnonadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doesthecompressorturnonspinner.setAdapter(doesthecompressorturnonadapter);

        heatingadapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, heatingoptions);
        heatingadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        heatingspinner.setAdapter(heatingadapter);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        whatistheproblem = (EditText) findViewById(R.id.whatistheproblemtext);

        Button nextbutton = (Button) findViewById(R.id.button4);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String doesitstart = doesitstartspinner.getSelectedItem().toString();
                String istheaccumulatorok = istheaccumulatorokspinner.getSelectedItem().toString();
                String istheengineflawless = istheengineflawlessspinner.getSelectedItem().toString();
                String fuel = fuelspinner.getSelectedItem().toString();
                String fuellevel = fuellevelspinner.getSelectedItem().toString();
                String changertype = changertypespinner.getSelectedItem().toString();
                String doestheairblowwork = doestheairblowworkspinner.getSelectedItem().toString();
                String doesthecompressorturnon = doesthecompressorturnonspinner.getSelectedItem().toString();
                String heating = heatingspinner.getSelectedItem().toString();

                String problem = whatistheproblem.getText().toString();

                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);
                String dtcsonignition = radioButton.getText().toString();

                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("dtcsonignition", dtcsonignition);
                editor.putString("doesitstart", doesitstart);
                editor.putString("doesitstart", doesitstart);
                editor.putString("istheaccumulatorok", istheaccumulatorok);
                editor.putString("istheengineflawless", istheengineflawless);
                editor.putString("whatistheproblem", problem);
                editor.putString("fuel", fuel);
                editor.putString("fuellevel", fuellevel);
                editor.putString("changertype", changertype);
                editor.putString("doestheairblowwork", doestheairblowwork);
                editor.putString("doesthecompressorturnon", doesthecompressorturnon);
                editor.putString("heating", heating);

                editor.apply();
            }
        });
    }
}
