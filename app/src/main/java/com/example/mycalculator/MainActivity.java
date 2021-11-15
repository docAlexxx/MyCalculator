package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView numbersTextView;
    private TextView processTextView;
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
    private MaterialButton pointButton;
    private MaterialButton signChangeButton;
    private MaterialButton resultButton;
    private MaterialButton deleteButton;
    private MaterialButton resetButton;
    Calculator calculator = new Calculator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initElements();
    }

    private void initElements() {
        numbersTextView = findViewById(R.id.number_screen);
        processTextView = findViewById(R.id.process_screen);
        number0Button = findViewById(R.id.zero_button);
        number1Button = findViewById(R.id.one_button);
        number2Button = findViewById(R.id.two_button);
        number3Button = findViewById(R.id.three_button);
        number4Button = findViewById(R.id.four_button);
        number5Button = findViewById(R.id.five_button);
        number6Button = findViewById(R.id.six_button);
        number7Button = findViewById(R.id.seven_button);
        number8Button = findViewById(R.id.eight_button);
        number9Button = findViewById(R.id.nine_button);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiplyButton = findViewById(R.id.multiply_button);
        devideButton = findViewById(R.id.divide_button);
        pointButton = findViewById(R.id.point_button);
        signChangeButton = findViewById(R.id.change_number_sign_button);
        resultButton = findViewById(R.id.result_button);
        deleteButton = findViewById(R.id.delete_button);
        resetButton = findViewById(R.id.reset_button);
    }

}