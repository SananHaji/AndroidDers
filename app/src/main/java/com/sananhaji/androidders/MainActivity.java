package com.sananhaji.androidders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String LAST_SAVED_RESULT = "LAST_SAVED_RESULT";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private TextView result;
    private EditText numberOne;
    private EditText numberTwo;
    private Button add;
    private Button multiply;
    private TextView lastSavedResult;
    private int a;
    private int b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        lastSavedResult = findViewById(R.id.last_saved_result);
        numberOne = findViewById(R.id.number_1);
        numberTwo = findViewById(R.id.number_2);
        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);

        preferences = getSharedPreferences("lastPreferences", MODE_PRIVATE);
        editor = preferences.edit();

        setLastSavedResult(preferences.getString(LAST_SAVED_RESULT, "0"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                setResult(String.valueOf(a + b));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                setResult(String.valueOf(a * b));
            }
        });

    }

    private void initValues() {
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
    }

    private void setResult(String text) {
        result.setText(text);
        setLastSavedResult(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void setLastSavedResult(String text){
        lastSavedResult.setText(text);
        editor.putString(LAST_SAVED_RESULT, text);
        editor.commit();
    }
}