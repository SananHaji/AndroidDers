package com.sananhaji.androidders.ui.activity.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.sananhaji.androidders.databinding.FragmentPageBinding;

public class PageFragment extends Fragment implements LifecycleObserver {

    FragmentPageBinding binding;
    MutableLiveData<String> sharedText;


    public static PageFragment newInstance(MutableLiveData<String> sharedText) {
        Bundle args = new Bundle();
        PageFragment fragment = new PageFragment(sharedText);
        fragment.setArguments(args);
        return fragment;
    }

    public PageFragment(MutableLiveData<String> sharedText) {
        this.sharedText = sharedText;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedText.observe(getViewLifecycleOwner(), s -> {
            binding.editTextTextPersonName.setText(s);
        });

        binding.button2.setOnClickListener(v -> sharedText.setValue(binding.editTextTextPersonName.getText().toString()));

    }
}
