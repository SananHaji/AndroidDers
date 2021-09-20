package com.sananhaji.androidders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.sananhaji.androidders.utils.Constants.STUDENT_ACTIVITY_RESULT;
import static com.sananhaji.androidders.utils.Constants.STUDENT_LIST_NAME;

public class MainActivity extends AppCompatActivity {

    private static final String LAST_SAVED_RESULT = "LAST_SAVED_RESULT";
    private static final int REQ_CODE_NAME = 333;
    private static final int REQ_CODE_SURNAME = 334;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private TextView result;
    private EditText numberOne;
    private EditText numberTwo;
    private Button add;
    private Button multiply;
    private Button goStudentList;
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
        goStudentList = findViewById(R.id.go_student_list);

        preferences = getSharedPreferences("lastPreferences", MODE_PRIVATE);
        editor = preferences.edit();

        setLastSavedResult(preferences.getString(LAST_SAVED_RESULT, "0"));
//
//        CountDownTimer timer = new CountDownTimer(30000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                lastSavedResult.setText(""+millisUntilFinished/1000);
//            }
//
//            @Override
//            public void onFinish() {
//                lastSavedResult.setText("FINISHED");
//
//            }
//        };
//        timer.start();

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

        goStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
                intent.putExtra(STUDENT_LIST_NAME, "TELEBELER");
//                startActivity(intent);
                //                startActivity(new Intent(MainActivity.this, StudentListActivity.class));
                if (numberOne.getText().toString().equals(""))
                    startActivityForResult(intent, REQ_CODE_NAME);
                else
                    startActivityForResult(intent, REQ_CODE_NAME);

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

    private void setLastSavedResult(String text) {
        lastSavedResult.setText(text);
        editor.putString(LAST_SAVED_RESULT, text);
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_NAME) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    lastSavedResult.setText(data.getStringExtra(STUDENT_ACTIVITY_RESULT));
                }
            } else if(resultCode==RESULT_CANCELED){
                if (data != null) {
                    lastSavedResult.setText("TELEBEBE BOSDUR");
                }
            }
        }


    }
}