package com.example.newcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText num1;
    EditText num2;
    Button plus;
    Button minus;
    Button  multiplication;
    Button  division;
    TextView result;
    final int PLUS = 1;
    final int MINUS = 2;
    final int MUL = 3;
    final int DIV = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText)findViewById(R.id.num1);
        num2 = (EditText)findViewById(R.id.num2);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiplication = (Button)findViewById(R.id.mul);
        division = (Button)findViewById(R.id. div);
        result =  (TextView)findViewById(R.id.result);
    }
    @Override
    public void onClick (View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("num1", Integer.valueOf(num1.getText().toString()));
        intent.putExtra("num2", Integer.valueOf(num2.getText().toString()));
        switch (v.getId()) {
            case R.id.plus:
                intent.putExtra("oper", Integer.valueOf(PLUS));
                startActivityForResult(intent, PLUS);
                break;
            case R.id.minus:
                intent.putExtra("oper", Integer.valueOf(MINUS));
                startActivityForResult(intent, MINUS);
                break;
            case R.id.mul:
                intent.putExtra("oper", Integer.valueOf(MUL));
                startActivityForResult(intent, MUL);
                break;
            case R.id.div:
                intent.putExtra("oper", Integer.valueOf(DIV));
                startActivityForResult(intent, DIV);
                break;
        }
    }
        @Override
        protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PLUS:
                    int sum = data.getIntExtra("sum", 0);
                    result.setText(String.valueOf(sum));
                    break;
                case MINUS:
                    int min = data.getIntExtra("min", 0);
                    result.setText(String.valueOf(min));
                    break;
                case MUL:
                    int mul = data.getIntExtra("mul", 0);
                    result.setText(String.valueOf(mul));
                    break;
                case DIV:
                    int div = data.getIntExtra("div", 0);
                    result.setText(String.valueOf(div));
                    break;
            }
        }
        else {
            result.setText("Неправильный результат");

        }
    }


}
