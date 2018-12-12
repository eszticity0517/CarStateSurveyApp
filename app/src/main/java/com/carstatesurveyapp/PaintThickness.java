package com.carstatesurveyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class PaintThickness extends AppCompatActivity {

    private SeekBar bonnetseekbar;
    private TextView bonnetseekbarvalue;

    private SeekBar rightfrontarcseekbar;
    private TextView rightfrontarcseekbarvalue;

    private SeekBar rightfrontdoorseekbar;
    private TextView rightfrontdoorseekbarvalue;

    private SeekBar rightreardoorseekbar;
    private TextView rightreardoorseekbarvalue;

    private SeekBar rightreararcseekbar;
    private TextView rightreararcseekbarvalue;

    private SeekBar tailgateseekbar;
    private TextView tailgateseekbarvalue;

    private SeekBar leftreararcseekbar;
    private TextView leftreararcseekbarvalue;

    private SeekBar leftreardoorseekbar;
    private TextView leftreardoorseekbarvalue;

    private SeekBar leftfrontdoorseekbar;
    private TextView leftfrontdoorseekbarvalue;

    private SeekBar topseekbar;
    private TextView topseekbarvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_thickness);

        bonnetseekbar = (SeekBar) findViewById(R.id.bonnetseekbar);
        bonnetseekbarvalue = (TextView) findViewById(R.id.bonnetseekbarvalue);
        bonnetseekbarvalue.setText("0");

        rightfrontarcseekbar = (SeekBar) findViewById(R.id.rightfrontarcseekbar);
        rightfrontarcseekbarvalue = (TextView) findViewById(R.id.rightfrontarcseekbarvalue);
        rightfrontarcseekbarvalue.setText("0");

        rightfrontdoorseekbar = (SeekBar) findViewById(R.id.rightfrontdoorseekbar);
        rightfrontdoorseekbarvalue = (TextView) findViewById(R.id.rightfrontdoorseekbarvalue);
        rightfrontdoorseekbarvalue.setText("0");

        rightreardoorseekbar = (SeekBar) findViewById(R.id.rightreardoorseekbar);
        rightreardoorseekbarvalue = (TextView) findViewById(R.id.rightreardoorseekbarvalue);
        rightreardoorseekbarvalue.setText("0");

        rightreararcseekbar = (SeekBar) findViewById(R.id.rightreararcseekbar);
        rightreararcseekbarvalue = (TextView) findViewById(R.id.rightreararcseebarvalue);
        rightreararcseekbarvalue.setText("0");

        tailgateseekbar = (SeekBar) findViewById(R.id.tailgateseekbar);
        tailgateseekbarvalue = (TextView) findViewById(R.id.tailgateseekbarvalue);
        tailgateseekbarvalue.setText("0");

        leftreararcseekbar = (SeekBar) findViewById(R.id.leftreararcseekbar);
        leftreararcseekbarvalue = (TextView) findViewById(R.id.leftreararcseekbarvalue);
        leftreararcseekbarvalue.setText("0");

        leftreardoorseekbar = (SeekBar) findViewById(R.id.leftreardoorseekbar);
        leftreardoorseekbarvalue = (TextView) findViewById(R.id.leftreardoorseekbarvalue);
        leftreardoorseekbarvalue.setText("0");

        leftfrontdoorseekbar = (SeekBar) findViewById(R.id.leftfrontdoorseekbar);
        leftfrontdoorseekbarvalue = (TextView) findViewById(R.id.leftfrontdoorseekbarvalue);
        leftfrontdoorseekbarvalue.setText("0");

        topseekbar = (SeekBar) findViewById(R.id.topseekbar);
        topseekbarvalue = (TextView) findViewById(R.id.topseekbarvalue);
        topseekbarvalue.setText("0");

        bonnetseekbar.setOnSeekBarChangeListener(new ChangeListener((bonnetseekbarvalue)));
        rightfrontarcseekbar.setOnSeekBarChangeListener(new ChangeListener((rightfrontarcseekbarvalue)));
        rightfrontdoorseekbar.setOnSeekBarChangeListener(new ChangeListener((rightfrontdoorseekbarvalue)));
        rightreardoorseekbar.setOnSeekBarChangeListener(new ChangeListener((rightreardoorseekbarvalue)));
        rightreararcseekbar.setOnSeekBarChangeListener(new ChangeListener((rightreararcseekbarvalue)));
        tailgateseekbar.setOnSeekBarChangeListener(new ChangeListener((tailgateseekbarvalue)));
        leftreararcseekbar.setOnSeekBarChangeListener(new ChangeListener((leftreararcseekbarvalue)));
        leftreardoorseekbar.setOnSeekBarChangeListener(new ChangeListener((leftreardoorseekbarvalue)));
        leftfrontdoorseekbar.setOnSeekBarChangeListener(new ChangeListener((leftfrontdoorseekbarvalue)));
        topseekbar.setOnSeekBarChangeListener(new ChangeListener((topseekbarvalue)));
    }

    private class ChangeListener implements SeekBar.OnSeekBarChangeListener {
        private TextView seekbarValue;

        public ChangeListener(TextView seekbarValue) {
            this.seekbarValue = seekbarValue;
        }

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            this.seekbarValue.setText("" + progress);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {}

        public void onStopTrackingTouch(SeekBar seekBar) {}

    }
}
