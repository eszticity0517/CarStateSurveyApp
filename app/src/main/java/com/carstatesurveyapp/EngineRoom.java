package com.carstatesurveyapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
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
                //First, get elements from spinner

                String antifreezeedegree = ((TextView) findViewById(R.id.antifreezedegreetext)).getText().toString();

                String engineroomcleanness = engineroomcleannessspinner.getSelectedItem().toString();
                String oilconsinstency = oilconsinstencyspinner.getSelectedItem().toString();
                String coolingwater = coolingwaterspinner.getSelectedItem().toString();
                String waterleaking = waterleakingspinner.getSelectedItem().toString();
                String engineroomcover = engineroomcoverspinner.getSelectedItem().toString();

                ImageView imageView=(ImageView) findViewById(R.id.ImageView);
                Bitmap image=((BitmapDrawable)imageView.getDrawable()).getBitmap();
                // String imagestring = BitMapToString(image);

                // Save data
                SharedPreferences settings = getApplicationContext().getSharedPreferences("PreferencesName", 0);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("engineroomcleanness", engineroomcleanness);
                editor.putString("oilconsinstency", oilconsinstency);
                editor.putString("coolingwater", coolingwater);
                editor.putString("waterleaking", waterleaking);
                editor.putString("antifreezeedegree", antifreezeedegree);
                editor.putString("engineroomcover", engineroomcover);
                editor.putString("pictureoftheengineroom", imageUri.toString());

                editor.apply();

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

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}
