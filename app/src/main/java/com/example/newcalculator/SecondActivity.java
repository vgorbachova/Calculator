package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {
    final int PLUS = 1;
    final int MINUS = 2;
    final int MUL = 3;
    final int DIV = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent1 = getIntent();
        int num1 = intent1.getIntExtra ("num1", 0);
        int num2 = intent1.getIntExtra ("num2", 0);
        int oper = intent1.getIntExtra ("oper", 0);
        switch (oper) {
            case PLUS:
                intent1.putExtra("sum", num1+num2);
                break;
            case MINUS:
                intent1.putExtra("min", num1-num2);
                break;
            case MUL:
                intent1.putExtra("mul", num1*num2);
                break;
            case DIV:
                intent1.putExtra("div", num1/num2);
                break;
        }
        setResult(RESULT_OK, intent1);
        finish();
    }

}
