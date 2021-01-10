package com.example.vaccinationpassport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class PassportActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView dobTextView;
    private TextView healthCareNumberTextView;
    private Button verifyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);

        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("byteArray");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        verifyButton = findViewById(R.id.verifyButton);
        verifyButton.setOnClickListener(onCreateVerify);
        ImageView image = (ImageView) findViewById(R.id.photo);
        image.setImageBitmap(bmp);

        firstNameTextView = (TextView) findViewById(R.id.first_name_value);
        firstNameTextView.setText(getIntent().getStringExtra("firstName"));
        lastNameTextView = (TextView) findViewById(R.id.last_name_value);
        lastNameTextView.setText(getIntent().getStringExtra("lastName"));
        dobTextView = (TextView) findViewById(R.id.dob_value);
        dobTextView.setText(getIntent().getStringExtra("dob"));
        healthCareNumberTextView = (TextView) findViewById(R.id.health_care_number_value);
        healthCareNumberTextView.setText(getIntent().getStringExtra("healthCareNumber"));
    }

    private View.OnClickListener onCreateVerify = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent newIntent = new Intent(getApplicationContext(), VerifyActivity.class);
            startActivity(newIntent);
        }
    };
}