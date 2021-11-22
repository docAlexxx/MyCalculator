package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class SettingsActivity extends AppCompatActivity {

    private MaterialButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> finish());

    }
}