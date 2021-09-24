package com.sananhaji.androidders.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sananhaji.androidders.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.calculator.setOnClickListener(v -> startActivity(new Intent(this, CalculatorActivity.class)));
        binding.studentList.setOnClickListener(v -> startActivity(new Intent(this, StudentListActivity.class)));
        binding.test.setOnClickListener(v -> startActivity(new Intent(this, TestActivity.class)));

    }
}