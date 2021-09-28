package com.sananhaji.androidders.ui.activity.viewpager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityDateTimeBinding;

public class DateTimeActivity extends AppCompatActivity {

    ActivityDateTimeBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.date.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(this);
            datePicker.setOnDateSetListener((view, year, month, dayOfMonth) -> {
                binding.edittext.setText(dayOfMonth+"/"+month+"/"+year );
            });
            datePicker.show();
        });


    }
}