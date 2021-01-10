package com.example.vaccinationpassport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;
    private Button createPassportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView2);
        createPassportButton = findViewById(R.id.createPassportButton);
        imageView.setOnClickListener(onUploadPhotoClick);
        createPassportButton.setOnClickListener(onCreatePassport);
    }

    private void dispatchTakePictureIntent() {
        System.out.println("here");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (Error e){
            System.out.println("oops");
        }
    }
    private View.OnClickListener onUploadPhotoClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dispatchTakePictureIntent();
        }
    };

    private View.OnClickListener onCreatePassport = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("here");
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            int imageViewWidth = imageView.getWidth();
            int imageViewHeight = imageView.getHeight();
            Bitmap newBitmap = Bitmap.createScaledBitmap(imageBitmap, imageViewWidth, imageViewHeight, true);
            imageView.setImageBitmap(newBitmap);
        }
    }

}