package com.sananhaji.androidders.ui.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityCalculatorBinding;

import static com.sananhaji.androidders.utils.Constants.STUDENT_ACTIVITY_RESULT;
import static com.sananhaji.androidders.utils.Constants.STUDENT_LIST_NAME;

public class CalculatorActivity extends AppCompatActivity {

    private static final String LAST_SAVED_RESULT = "LAST_SAVED_RESULT";
    private static final int REQ_CODE_NAME = 333;
    private static final int REQ_CODE_SURNAME = 334;

    ActivityCalculatorBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private int a;
    private int b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("lastPreferences", MODE_PRIVATE);
        editor = preferences.edit();

        setLastSavedResult(preferences.getString(LAST_SAVED_RESULT, "0"));

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                setResult(String.valueOf(a + b));
            }
        });

        binding.multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initValues();
                setResult(String.valueOf(a * b));
            }
        });

//        goStudentList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CalculatorActivity.this, StudentListActivity.class);
//                intent.putExtra(STUDENT_LIST_NAME, "TELEBELER");
////                startActivity(intent);
//                //                startActivity(new Intent(MainActivity.this, StudentListActivity.class));
//
//                startActivityForResult(intent, REQ_CODE_NAME);
//
//            }
//        });

    }

    private void initValues() {
        if (!binding.number1.getText().toString().equals("")) {
            a = Integer.parseInt(binding.number1.getText().toString());
        } else {
            a = 0;
        }

        if (!binding.number2.getText().toString().equals("")) {
            b = Integer.parseInt(binding.number2.getText().toString());
        } else {
            b = 0;
        }
    }

    private void setResult(String text) {
        binding.result.setText(text);
        setLastSavedResult(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void setLastSavedResult(String text) {
        binding.lastSavedResult.setText(text);
        editor.putString(LAST_SAVED_RESULT, text);
        editor.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE_NAME) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    binding.lastSavedResult.setText(data.getStringExtra(STUDENT_ACTIVITY_RESULT));
                }
            } else if (resultCode == RESULT_CANCELED) {
                if (data != null) {
                    binding.lastSavedResult.setText("TELEBEBE BOSDUR");
                }
            }
        }


    }
}