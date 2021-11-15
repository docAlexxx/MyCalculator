package com.example.mycalculator;

import java.io.Serializable;

public class Calculator implements Serializable {
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
        if (!isError) {
            switch (lastAction) {
                case ("number"):
                    changeNumber(digit);
                    break;
                case ("process"):
                    currentNumber = "";
                    isDecimal = false;
                    isNegative = false;
                    numberLength = 0;
                    changeNumber(digit);
                    break;
                case ("result"):
                    currentNumber = "";
                    isDecimal = false;
                    isNegative = false;
                    numberLength = 0;
                    result = 0;
                    operation = "plus";
                    processToScreen = "";
                    changeNumber(digit);
                    break;
            }
            lastAction = "number";
            numberToScreen = currentNumber;
        }
    }

    private void changeNumber(String digit) {
        if (digit.equals("point")) {
            addPoint();
            return;
        }

        if (digit.equals("+/-")) {
            changeNumberSign();
            return;
        }

        if (digit.equals("del")) {
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
            if (currentNumber.equals("")) {
                currentNumber = "0.";
                numberLength++;
            } else if (currentNumber.equals("-")) {
                currentNumber = "-0.";
                numberLength++;
            } else {
                currentNumber = currentNumber + ".";
            }
            isDecimal = true;
        }
    }

    public void changeNumberSign() {
        if (currentNumber.equals("")) {
            currentNumber = "-";
            isNegative = true;
        } else {
            if (Double.parseDouble(currentNumber) < 0) {
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
        if (!currentNumber.equals("")) {
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
        if (currentNumber.equals("")) {
            operation = "plus";
            lastAction = "process";
            numberToScreen = "0";
            processToScreen = "";
        }
    }

    public void processButtonPush(String nextOperator) {
        if (!isError) {
            switch (lastAction) {
                case ("number"):
                    counting();
                    currentNumber = String.valueOf(result);
                    numberToScreen = currentNumber;
                    updateNumberToScreen();
                    break;
                case ("result"):
                    currentNumber = String.valueOf(result);
                    break;
            }
            lastAction = "process";
            operation = nextOperator;
            processToScreen = operation;
        }
    }

    public void counting() {
        double operationNumber;

        if (!currentNumber.equals("")) {
            operationNumber = currentNumberToDouble(currentNumber);
        } else {
            operationNumber = 0.0;
        }
        switch (operation) {
            case ("plus"):
                result = result + operationNumber;
                break;
            case ("minus"):
                result = result - operationNumber;
                break;
            case ("multiply"):
                result = result * operationNumber;
                break;
            case ("divide"): {
                if (operationNumber == 0) {
                    isError = true;
                } else {
                    result = result / operationNumber;
                }
            }
            break;

        }
        checkResult();
    }

    public double currentNumberToDouble(String number) {
        int intgerPart = 0;
        int decimalPart = 0;
        int afterpoint = 0;
        int dotIndex = number.indexOf(".");

        if (dotIndex>0) {
            intgerPart = Integer.parseInt(number.substring(0, dotIndex));
            decimalPart = Integer.parseInt(number.substring(dotIndex + 1));
            afterpoint = number.length() - 1 - dotIndex;
        } else {
            intgerPart = Integer.parseInt(number);
        }
        return intgerPart + decimalPart / Math.pow(10, afterpoint);
    }

    private void checkResult() {
        int intLength = 0;
        result = Math.round(result * Math.pow(10, MAX_LENGTH - 1)) / Math.pow(10, MAX_LENGTH - 1);
        int checkRes = (int) result;

        do {
            checkRes = checkRes / 10;
            intLength++;
        } while (checkRes != 0);

        if (intLength > MAX_LENGTH) {
            isError = true;
        } else {
            result = Math.round(result * Math.pow(10, MAX_LENGTH - intLength)) / Math.pow(10, MAX_LENGTH - intLength);
        }
    }

    public void resultButtonPush() {
        if (!isError) {
            lastAction = "result";
            counting();
            numberToScreen = String.valueOf(result);
            updateNumberToScreen();

        }
    }

    public void updateNumberToScreen() {
        int dotIndex = numberToScreen.indexOf(".");
        int decimalPart = Integer.parseInt(numberToScreen.substring(dotIndex + 1));

        if (decimalPart == 0) {
            numberToScreen = numberToScreen.substring(0, dotIndex);
        }


    }


}
