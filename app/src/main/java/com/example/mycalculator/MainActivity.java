package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        setupButtons();
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

    private void setupButtons() {
        resetButton.setOnClickListener(v -> {
            calculator.resetButtonPush();
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        deleteButton.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("del");
            NumberToScreen();
        });
        plusButton.setOnClickListener(v -> {
            calculator.processButtonPush("plus");
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        minusButton.setOnClickListener(v -> {
            calculator.processButtonPush("minus");
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        multiplyButton.setOnClickListener(v -> {
            calculator.processButtonPush("multiply");
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        devideButton.setOnClickListener(v -> {
            calculator.processButtonPush("divide");
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        pointButton.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("point");
            NumberToScreen();
        });
        signChangeButton.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("+/-");
            NumberToScreen();
        });
        resultButton.setOnClickListener(v -> {
            calculator.resultButtonPush();
            NumberToScreen();
            processTextView.setText(calculator.operation);
        });
        number0Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("0");
            NumberToScreen();
        });
        number1Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("1");
            NumberToScreen();
        });
        number2Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("2");
            NumberToScreen();
        });
        number3Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("3");
            NumberToScreen();
        });
        number4Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("4");
            NumberToScreen();
        });
        number5Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("5");
            NumberToScreen();
        });
        number6Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("6");
            NumberToScreen();
        });
        number7Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("7");
            NumberToScreen();
        });
        number8Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("8");
            NumberToScreen();
        });
        number9Button.setOnClickListener(v -> {
            calculator.changeNumberButtonPush("9");
            NumberToScreen();
        });
    }

    public void NumberToScreen() {
        if (calculator.isError) {
            numbersTextView.setText("ERROR");
        } else {
            numbersTextView.setText(calculator.numberToScreen);
        }
    }



}