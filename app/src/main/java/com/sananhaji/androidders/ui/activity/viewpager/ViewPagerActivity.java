package com.sananhaji.androidders.ui.activity.viewpager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayoutMediator;
import com.sananhaji.androidders.databinding.ActivityViewPagerBinding;

public class ViewPagerActivity extends AppCompatActivity {

    ActivityViewPagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new PagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
           tab.setText("TAB: "+position);
        }).attach();

    }
}