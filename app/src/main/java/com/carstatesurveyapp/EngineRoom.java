package com.carstatesurveyapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

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

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engine_room);

        ImageView imgFavorite = (ImageView) findViewById(R.id.ImageView);
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto(v);
            }
        });

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

    public void takePhoto(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.ImageView);
        imageView.setImageDrawable(null);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(photo));
        imageUri = Uri.fromFile(photo);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 0:
                if (resultCode == Activity.RESULT_OK) {
                    Uri selectedImage = imageUri;
                    getContentResolver().notifyChange(selectedImage, null);
                    ImageView imageView = (ImageView) findViewById(R.id.ImageView);
                    ContentResolver cr = getContentResolver();
                    Bitmap bitmap;
                    try {
                        bitmap = android.provider.MediaStore.Images.Media
                                .getBitmap(cr, selectedImage);

                        imageView.setImageBitmap(bitmap);
                        Toast.makeText(this, selectedImage.toString(),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT)
                                .show();
                        Log.e("Camera", e.toString());
                    }
                }
        }
    }
}
