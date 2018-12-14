package com.carstatesurveyapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GeneralInfo extends AppCompatActivity {
    private EditText receptiondate;
    private Calendar myCalendar;
    private  DatePickerDialog.OnDateSetListener date;

    private Spinner brandspinner;
    private Spinner comefromspinner;
    private Spinner bodytypesspinner;

    private ArrayAdapter<String>  brandadapter;
    private ArrayAdapter<String>  comefromadapter;
    private ArrayAdapter<String>  bodytypesadapter;

    private String[] brands;
    private String[] comefroms;
    private String[] bodytypes;
    private Button nextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info2);

        myCalendar = Calendar.getInstance();
        receptiondate = (EditText) findViewById(R.id.receptiondatetext);

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        receptiondate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(GeneralInfo.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        nextbutton = findViewById(R.id.button4);
        nextbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                // First get selected values from spinner
                String brand = brandspinner.getSelectedItem().toString();
                String camefrom = comefromspinner.getSelectedItem().toString();
                String bodytype = bodytypesspinner.getSelectedItem().toString();

                // After we get data from TextViews
                TextView vintagetext = (TextView) findViewById(R.id.vintagetext);
                String vintage = vintagetext.getText().toString();

                TextView licenceplatenumbertext = (TextView) findViewById(R.id.licenceplatenumbertext);
                String licenceplatenumber = licenceplatenumbertext.getText().toString();

                TextView vintext = (TextView) findViewById(R.id.vintext);
                String vin = vintext.getText().toString();

                TextView kilometerstext = (TextView) findViewById(R.id.kilometerstext);
                String kilometers = kilometerstext.getText().toString();

                TextView numberofkeystext = (TextView) findViewById(R.id.numberofkeystext);
                String numberofkeys = numberofkeystext.getText().toString();

                TextView receptiondatetext = (TextView) findViewById(R.id.receptiondatetext);
                String receptiondate = receptiondatetext.getText().toString();

                // Save data
                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("brand", brand);
                editor.putString("vintage", vintage);
                editor.putString("licenceplatenumber", licenceplatenumber);
                editor.putString("VIN", vin);
                editor.putString("camefrom", camefrom);
                editor.putString("kilometers", kilometers);
                editor.putString("bodytype", bodytype);
                editor.putString("numberofkeys", numberofkeys);
                editor.putString("receptiondate", receptiondate);

                // Apply the edits!
                editor.apply();
                Intent k = new Intent(GeneralInfo.this, BodyAesthetic.class);
                startActivity(k);
            }
        });

        // This info will come from an API function.
        brands = new String[] {
                "Alfa Romeo", "Bentley", "BMW", "Fiat", "Mazda", "Opel", "Wolkswagen"
        };

        comefroms = new String[] {
                "Auto1", "Commission", "Set-off", "From the street", "COTW"
        };

        bodytypes = new String[] {
                "Hatchback", "Small city", "MPV", "Beach-wagon", "SUV", "Sedan", "Cabrio", "4x4", "TKG"
        };

        brandspinner = (Spinner) findViewById(R.id.brandspinner);

        brandadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, brands);
        brandadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandspinner.setAdapter(brandadapter);

        comefromspinner = (Spinner) findViewById(R.id.comefromspinner);
        comefromadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, comefroms);
        comefromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comefromspinner.setAdapter(comefromadapter);

        bodytypesspinner = (Spinner) findViewById(R.id.bodytypespinner);
        bodytypesadapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, bodytypes);
        bodytypesadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bodytypesspinner.setAdapter(bodytypesadapter);
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        receptiondate.setText(sdf.format(myCalendar.getTime()));
    }
}
