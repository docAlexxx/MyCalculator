package com.example.mycalculator;

public class Calculator {
    public double result;
    public double number;
    public String currentNumber;
    public String operation;
    public String lastAction;
    public String numberToScreen;
    public String processToScreen;
    public boolean isDecimal;
    public boolean isNegative;
    public boolean isError;
    private final int MAX_LENGTH = 13;
    private int numberLength;


    public Calculator() {
        result = 0;
        number = 0;
        currentNumber = "";
        operation = "plus";
        lastAction = "process";
        numberToScreen = "0";
        processToScreen = "";
        isDecimal = false;
        isNegative = false;
        isError = false;
        numberLength = 0;
    }

    public void changeNumberButtonPush(String digit) {
        switch (lastAction) {
            case ("number"):
                changeNumber(digit);
                break;
            case ("process"):
                currentNumber = "";
                changeNumber(digit);
                break;
            case ("result"):
                currentNumber = "";
                changeNumber(digit);
                break;
        }

        lastAction = "number";
        numberToScreen = currentNumber;
    }

    private void changeNumber(String digit) {
        if (digit == ".") {
            addPoint();
            return;
        }

        if (digit == "+/-") {
            changeNumberSign();
            return;
        }

        if (digit == "del") {
            deleteDigit();
            return;
        }

        if (numberLength < MAX_LENGTH) {
            currentNumber = currentNumber + digit;
            numberLength++;
        } else {
            isError = true;
        }
    }

    private void addPoint() {
        if (!isDecimal) {
            if (currentNumber == "") {
                currentNumber = "0.";
                numberLength++;
            } else if (currentNumber == "-") {
                currentNumber = "-0.";
                numberLength++;
            } else {
                currentNumber = currentNumber + ".";
            }
            isDecimal = true;
        }
    }

    public void changeNumberSign() {
        if (currentNumber == "") {
            currentNumber = "-";
            isNegative = true;
        } else {
            if (Double.valueOf(currentNumber) < 0) {
                currentNumber = currentNumber.substring(1);
                isNegative = false;
            } else {
                currentNumber = "-" + currentNumber;
                isNegative = true;
            }
        }
    }

    public void resetButtonPush() {
        result = 0;
        number = 0;
        currentNumber = "";
        operation = "plus";
        lastAction = "process";
        numberToScreen = "0";
        processToScreen = "";
        isDecimal = false;
        isNegative = false;
        isError = false;
        numberLength = 0;
    }

    public void deleteDigit() {
        if (currentNumber != "") {
            Character lastSymbol = currentNumber.charAt(currentNumber.length() - 1);
            if (lastSymbol.equals('.')) {
                isDecimal = false;
            }
            if (lastSymbol.equals('-')) {
                isNegative = false;
            }
            if (currentNumber.length() == 1) {
                currentNumber = "";
            } else {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            }
            if (!lastSymbol.equals('.') && !lastSymbol.equals('-')) {
                numberLength--;
            }
        }
    }


}
