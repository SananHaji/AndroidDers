package com.sananhaji.androidders.ui.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sananhaji.androidders.databinding.ActivityDateTimeBinding;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {

    ActivityDateTimeBinding binding;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDateTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        binding.edittext.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    DateTimeActivity.this.year = year;
                    DateTimeActivity.this.month = month;
                    DateTimeActivity.this.day = dayOfMonth;
                    binding.edittext.setText(dayOfMonth + "/" + month + "/" + year);
                }
            }, year, month, day);

            datePicker.show();
        });

        binding.clock.setOnClickListener(v -> {
            TimePickerDialog timePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    DateTimeActivity.this.hour = hourOfDay;
                    DateTimeActivity.this.minute = minute;
                    binding.clock.setText(hourOfDay + ":" + minute);
                }
            }, hour, minute, true);

            timePicker.show();
        });


    }
}