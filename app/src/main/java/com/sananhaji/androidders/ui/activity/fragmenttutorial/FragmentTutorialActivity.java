package com.sananhaji.androidders.ui.activity.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityFragmentTutorialBinding;

public class FragmentTutorialActivity extends AppCompatActivity {

    ActivityFragmentTutorialBinding binding;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentTutorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(binding.frameLayout.getId(), BlankFragment.newInstance("1 Page", R.color.purple_200))
                .commit();
        fragmentManager.beginTransaction().add(binding.frameLayout2.getId(), BlankFragment.newInstance("2 Page", R.color.purple_500)).commit();
        fragmentManager.beginTransaction().add(binding.frameLayout3.getId(), BlankFragment.newInstance("3 Page", R.color.purple_700)).commit();
        fragmentManager.beginTransaction().add(binding.frameLayout4.getId(), BlankFragment.newInstance("4 Page", R.color.teal_200)).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}