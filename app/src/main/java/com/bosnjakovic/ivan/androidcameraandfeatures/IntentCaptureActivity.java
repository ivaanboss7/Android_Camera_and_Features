package com.bosnjakovic.ivan.androidcameraandfeatures;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IntentCaptureActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView ivPhoto;
    private Button bCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_capture);

        initWidgets();
        setUpListeners();
        checkCameraAvailability();
    }

    private void checkCameraAvailability() {
        if (!hasCamera()) {
            bCapture.setEnabled(false);
        }
    }

    private void initWidgets() {
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        bCapture = (Button) findViewById(R.id.bIntentCapture);
    }

    private void setUpListeners() {
        bCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            Bitmap photo = (Bitmap) bundle.get("data");
            ivPhoto.setRotation(90f);
            ivPhoto.setImageBitmap(photo);
        }
    }

    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

}
