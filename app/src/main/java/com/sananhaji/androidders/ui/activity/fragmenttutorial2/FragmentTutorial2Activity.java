package com.sananhaji.androidders.ui.activity.fragmenttutorial2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityFragmentTutorial2Binding;

public class FragmentTutorial2Activity extends AppCompatActivity {

    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";

    private ActivityFragmentTutorial2Binding binding;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentTutorial2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();

        // add
        fragmentManager.beginTransaction().add(
                binding.frameLayout6.getId(),
                TutorialFragment.newInstance(R.drawable.ic_success),
                FRAGMENT_TAG
        ).commit();

        fragmentManager.beginTransaction().add(
                binding.frameLayout.getId(),
                TutorialFragment.newInstance(R.drawable.ic_success),
                FRAGMENT_TAG
        ).commit();

        binding.button5.setOnClickListener(v -> {
            // replace
            fragmentManager.beginTransaction().replace(
                    binding.frameLayout6.getId(),
                    TutorialFragment.newInstance(R.drawable.ic_launcher_background),
                    FRAGMENT_TAG
            ).commit();

            fragmentManager.beginTransaction().replace(
                    binding.frameLayout.getId(),
                    TutorialFragment.newInstance(R.drawable.ic_launcher_background),
                    FRAGMENT_TAG
            ).commit();
        });

        binding.button6.setOnClickListener(v -> {
            // remove
            Fragment fragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG);
            if (fragment != null) {
                fragmentManager.beginTransaction().remove(fragment).commit();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}