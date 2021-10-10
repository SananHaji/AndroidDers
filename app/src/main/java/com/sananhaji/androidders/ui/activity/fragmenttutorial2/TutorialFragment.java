package com.sananhaji.androidders.ui.activity.fragmenttutorial2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.FragmentTutorialBinding;

public class TutorialFragment extends Fragment {

    private static final String TUTORIAL_IMAGE = "TUTORIAL_IMAGE";
    FragmentTutorialBinding binding;

    private @DrawableRes int image;

    // 1
    public static TutorialFragment newInstance(@DrawableRes int image) {
        // this.image = image;
        Bundle args = new Bundle();
        TutorialFragment fragment = new TutorialFragment();
        args.putInt(TUTORIAL_IMAGE, image);
        fragment.setArguments(args);
        return fragment;
    }

    // 2
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.image = getArguments().getInt(TUTORIAL_IMAGE);
        }
    }

    // 3
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTutorialBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            binding.imageView3.setImageDrawable(ResourcesCompat.getDrawable(
                    getResources(),
                    image,
                    getActivity().getTheme()
            ));
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
