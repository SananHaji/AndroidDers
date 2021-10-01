package com.sananhaji.androidders.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivitySpinnerBinding;

import java.util.Arrays;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private List<String> studentNames = Arrays.asList("senan", "tural", "fazil", "cumsud");

    ArrayAdapter<String> adapter;

    ActivitySpinnerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ArrayAdapter<>(this, R.layout.item_list_student, R.id.textView3, studentNames);

        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, studentNames.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SpinnerActivity.this, "you did not select anything", Toast.LENGTH_SHORT).show();
            }
        });

        binding.button4.setOnClickListener(v -> {
            int position = binding.spinner.getSelectedItemPosition();
            Toast.makeText(SpinnerActivity.this, studentNames.get(position), Toast.LENGTH_SHORT).show();
        });




    }
}