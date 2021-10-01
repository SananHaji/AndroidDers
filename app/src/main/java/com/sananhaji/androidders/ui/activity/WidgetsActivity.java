package com.sananhaji.androidders.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityWidgetsBinding;

public class WidgetsActivity extends AppCompatActivity {

    private static final String TAG = "WidgetsActivity";
    ActivityWidgetsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWidgetsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button3.setOnClickListener(v -> {
            checkChange(binding.radioGroup.getCheckedRadioButtonId());
            //switch
//            Toast.makeText(getApplicationContext(), ""+binding.switch1.isChecked(), Toast.LENGTH_SHORT).show();
            // toggle
            Toast.makeText(getApplicationContext(), ""+binding.toggleButton.isChecked(), Toast.LENGTH_SHORT).show();
        });

        // radio

        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // logging example
            Log.d(TAG, "onCreate: check changed: "+checkedId);
            Log.i(TAG, "onCreate: check changed: "+checkedId);
            Log.w(TAG, "onCreate: check changed: "+checkedId);
            Log.e(TAG, "onCreate: check changed: "+checkedId);
            checkChange(checkedId);
        });

        // handler
        new Handler().postDelayed(() -> binding.radio3.setChecked(true), 5000);

        // switch
//        binding.switch1.setEnabled(false);

        binding.progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> binding.progressBar.setVisibility(View.GONE),3000);



    }

    private void checkChange(int id) {
        String val = "";
        switch (id) {
            case R.id.radio1:
                val = binding.radio1.getText().toString();
                break;
            case R.id.radio2:
                val = binding.radio2.getText().toString();
                break;
            case R.id.radio3:
                val = binding.radio3.getText().toString();
                break;
        }
        binding.textView2.setText(val);
    }
}