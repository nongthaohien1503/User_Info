package com.example.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        String phone1 = intent.getStringExtra("phone");
        String gender1 = intent.getStringExtra("gender");
        String education1 = intent.getStringExtra("education");
        int age1 = intent.getIntExtra("age", 0);
        String sports1 = intent.getStringExtra("sports");
        String music1 = intent.getStringExtra("music");

        TextView nameTextView = findViewById(R.id.nameTV);
        nameTextView.setText(name1);

        TextView phoneTextView = findViewById(R.id.phoneTV);
        phoneTextView.setText(phone1);

        TextView genderTextView = findViewById(R.id.genderTV);
        genderTextView.setText(gender1);

        TextView educationTextView = findViewById(R.id.educationTV);
        educationTextView.setText(education1);

        TextView ageTextView = findViewById(R.id.ageTV);
        ageTextView.setText(String.valueOf(age1));

        TextView sportsTextView = findViewById(R.id.sportsTV);
        sportsTextView.setText(sports1);

        TextView musicTextView = findViewById(R.id.musicTV);
        musicTextView.setText(music1);
    }
}