package com.example.mayurcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean isOperatorClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        if (isOperatorClicked) {
            currentNumber = "";
            isOperatorClicked = false;
        }
        currentNumber += button.getText().toString();
        tvDisplay.setText(currentNumber);
    }

    public void onOperationClick(View view) {
        Button button = (Button) view;
        if (!currentNumber.equals("")) {
            firstNumber = Double.parseDouble(currentNumber);
        }
        operator = button.getText().toString();
        isOperatorClicked = true;
    }

    public void onEqualsClick(View view) {
        double result = 0;
        double secondNumber = Double.parseDouble(currentNumber);

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    tvDisplay.setText("Error");
                    return;
                }
                break;
        }

        tvDisplay.setText(String.valueOf(result));
        currentNumber = String.valueOf(result);
        operator = "";
    }

    public void onClearClick(View view) {
        currentNumber = "";
        operator = "";
        firstNumber = 0;
        tvDisplay.setText("0");
    }
}
