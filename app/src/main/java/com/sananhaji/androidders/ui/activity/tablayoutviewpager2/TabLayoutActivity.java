package com.sananhaji.androidders.ui.activity.tablayoutviewpager2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayoutMediator;
import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityTabLayoutBinding;

public class TabLayoutActivity extends AppCompatActivity {

    private ActivityTabLayoutBinding binding;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(adapter = new ViewPagerAdapter(this));
        new TabLayoutMediator(binding.tabLayout2, binding.viewPager, (tab, position) -> {
            tab.setText("tab: " + position);
            if (position == 0)
                tab.setIcon(R.drawable.ic_baseline_style_24);
        }).attach();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}