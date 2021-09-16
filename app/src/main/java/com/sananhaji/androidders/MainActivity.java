package com.sananhaji.androidders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText numberOne;
    private EditText numberTwo;
    private Button add;
    private Button multiply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        numberOne = findViewById(R.id.number_1);
        numberTwo = findViewById(R.id.number_2);
        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);

        result.setText("0");

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;


                if (!numberOne.getText().toString().equals("")) {
                    a = Integer.parseInt(numberOne.getText().toString());
                } else {
                    a = 0;
                }

                if (!numberTwo.getText().toString().equals("")) {
                    b = Integer.parseInt(numberTwo.getText().toString());
                } else {
                    b = 0;
                }

                int toplam = a + b;

                result.setText(String.valueOf(toplam));


            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;


                if (!numberOne.getText().toString().equals("")) {
                    a = Integer.parseInt(numberOne.getText().toString());
                } else {
                    a = 0;
                }

                if (!numberTwo.getText().toString().equals("")) {
                    b = Integer.parseInt(numberTwo.getText().toString());
                } else {
                    b = 0;
                }

                int toplam = a * b;

                result.setText(String.valueOf(toplam));


            }
        });

    }
}