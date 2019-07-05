package com.example.basic_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2;
    float val1, val2;
    EditText et1, et2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.btn_mode);
        bt2 = findViewById(R.id.btnCal);
        et1 = findViewById(R.id.field1Value);
        et2 = findViewById(R.id.field2Value);
        res = findViewById(R.id.resVal);
        et1.setSelection(0);

    }


    public void selectMode(View view){
        String op = bt1.getText().toString();
        if(op == "+")
            bt1.setText("-");
        else if (op == "-")
            bt1.setText("*");
        else if (op == "*")
            bt1.setText("/");
        else
            bt1.setText("+");
    }

    public void calculate(View view) {
        if (et1.getText().toString() == null && et2.getText().toString() == null)
            Toast.makeText(MainActivity.this, "Please enter two numbers", Toast.LENGTH_LONG).show();
        else if (et1.getText().toString() == "")
            Toast.makeText(MainActivity.this, "Please enter a value in Field 1", Toast.LENGTH_LONG).show();
        else if (et2.getText().toString() == "")
            Toast.makeText(MainActivity.this, "Please enter a value in Field 2", Toast.LENGTH_LONG).show();
        else {
            val1 = Float.parseFloat(et1.getText().toString());
            val2 = Float.parseFloat(et2.getText().toString());
            if (bt1.getText().toString() == "+")
                res.setText(String.valueOf(val1 + val2));
            else if (bt1.getText().toString() == "-")
                res.setText(String.valueOf(val1 - val2));
            else if (bt1.getText().toString() == "*")
                res.setText(String.valueOf(val1 * val2));
            else if (bt1.getText().toString() == "/"){
                if(val2==0)
                    Toast.makeText(this, "CANNOT DIVIDE BY ZERO", Toast.LENGTH_LONG).show();
                else
                    res.setText(String.valueOf(val1 / val2));
            }

        }
    }
}
