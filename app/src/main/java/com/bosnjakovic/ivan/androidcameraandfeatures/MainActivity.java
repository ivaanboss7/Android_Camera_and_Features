package com.bosnjakovic.ivan.androidcameraandfeatures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bIntentCamera;
    private Button bApplicationCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        setUpListeners();
    }

    private void initWidgets() {

        bIntentCamera = (Button) findViewById(R.id.bIntentCamera);
        bApplicationCamera = (Button) findViewById(R.id.bAppCamera);

    }

    private void setUpListeners() {
        bIntentCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, IntentCaptureActivity.class);
                startActivity(intent);

            }
        });

        bApplicationCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApplicationCaptureActivity.class);
                startActivity(intent);

            }
        });
    }

}