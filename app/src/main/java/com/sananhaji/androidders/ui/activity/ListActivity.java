package com.sananhaji.androidders.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityListBinding;

import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<String> studentNames = Arrays.asList("senan", "tural", "fazil", "cumsud");
    private List<String> studentSurnames = Arrays.asList("Haci", "Yusifli", "fazilli", "cumsudlu");

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterSurname;

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ArrayAdapter<>(this, R.layout.item_list_student, R.id.textView3, studentNames);
        adapterSurname = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, studentSurnames);

        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, studentNames.get(position), Toast.LENGTH_SHORT).show();
        });

        binding.gridView.setAdapter(adapterSurname);
        binding.gridView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, studentSurnames.get(position), Toast.LENGTH_SHORT).show();
        });
    }
}