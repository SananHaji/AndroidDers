package com.sananhaji.androidders.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sananhaji.androidders.databinding.ActivityMainBinding;
import com.sananhaji.androidders.models.Currency;
import com.sananhaji.androidders.ui.activity.currencies.CurrenciesActivity;
import com.sananhaji.androidders.ui.activity.person.PersonActivity;
import com.sananhaji.androidders.ui.activity.fragmenttutorial.FragmentTutorialActivity;
import com.sananhaji.androidders.ui.activity.fragmenttutorial2.FragmentTutorial2Activity;
import com.sananhaji.androidders.ui.activity.recycler.RecyclerActivity;
import com.sananhaji.androidders.ui.activity.viewpager.ViewPagerActivity;

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
        binding.viewPager.setOnClickListener(v -> startActivity(new Intent(this, ViewPagerActivity.class)));
        binding.widgets.setOnClickListener(v -> startActivity(new Intent(this, WidgetsActivity.class)));
        binding.webview.setOnClickListener(v -> startActivity(new Intent(this, WebViewActivity.class)));
        binding.date.setOnClickListener(v -> startActivity(new Intent(this, DateTimeActivity.class)));
        binding.listActivity.setOnClickListener(v -> startActivity(new Intent(this, ListActivity.class)));
        binding.spinner.setOnClickListener(v -> startActivity(new Intent(this, SpinnerActivity.class)));
        binding.menu.setOnClickListener(v -> startActivity(new Intent(this, ToolbarActivity.class)));
        binding.students.setOnClickListener(v -> startActivity(new Intent(this, RecyclerActivity.class)));
        binding.currencies.setOnClickListener(v -> startActivity(new Intent(this, CurrenciesActivity.class)));
        binding.fragmentTutorial.setOnClickListener(v -> startActivity(new Intent(this, FragmentTutorialActivity.class)));
        binding.fragmentTutorial2.setOnClickListener(v -> startActivity(new Intent(this, FragmentTutorial2Activity.class)));
        binding.person.setOnClickListener(v -> startActivity(new Intent(this, PersonActivity.class)));

    }
}