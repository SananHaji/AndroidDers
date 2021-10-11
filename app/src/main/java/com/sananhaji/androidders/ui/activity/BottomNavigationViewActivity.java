package com.sananhaji.androidders.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityBottomNavigationViewBinding;
import com.sananhaji.androidders.databinding.FragmentFirstBinding;
import com.sananhaji.androidders.ui.activity.tablayoutviewpager2.FirstFragment;
import com.sananhaji.androidders.ui.activity.tablayoutviewpager2.SecondFragment;
import com.sananhaji.androidders.ui.activity.tablayoutviewpager2.ThirdFragment;

public class BottomNavigationViewActivity extends AppCompatActivity {

    private ActivityBottomNavigationViewBinding binding;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBottomNavigationViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(binding.frame.getId(), FirstFragment.newInstance()).commit();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_star:
                    fragmentManager.beginTransaction().replace(binding.frame.getId(), FirstFragment.newInstance()).commit();
                    return true;
                case R.id.nav_handball:
                    fragmentManager.beginTransaction().replace(binding.frame.getId(), SecondFragment.newInstance()).commit();
                    return true;
                case R.id.nav_style:
                    fragmentManager.beginTransaction().replace(binding.frame.getId(), ThirdFragment.newInstance()).commit();
                    return true;
            }
            return false;
        });
    }
}