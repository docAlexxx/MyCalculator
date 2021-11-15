package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText numbersEditText;
    private EditText actionEditText;
    private MaterialButton number0Button;
    private MaterialButton number1Button;
    private MaterialButton number2Button;
    private MaterialButton number3Button;
    private MaterialButton number4Button;
    private MaterialButton number5Button;
    private MaterialButton number6Button;
    private MaterialButton number7Button;
    private MaterialButton number8Button;
    private MaterialButton number9Button;
    private MaterialButton plusButton;
    private MaterialButton minusButton;
    private MaterialButton multiplyButton;
    private MaterialButton devideButton;
    private MaterialButton dotButton;
    private MaterialButton plusMinusChangeButton;
    private MaterialButton resultButton;
    private MaterialButton deleteButton;
    private MaterialButton resetButton;
    private MaterialButton settingButton;
    Calculator calculator = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}