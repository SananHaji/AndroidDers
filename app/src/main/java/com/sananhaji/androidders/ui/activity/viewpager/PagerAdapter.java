package com.sananhaji.androidders.ui.activity.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Arrays;
import java.util.List;

public class PagerAdapter extends FragmentStateAdapter {

    MutableLiveData<String> sharedText = new MutableLiveData<>();

    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(sharedText);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
