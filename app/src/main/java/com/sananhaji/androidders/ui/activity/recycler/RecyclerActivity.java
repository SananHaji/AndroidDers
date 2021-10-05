package com.sananhaji.androidders.ui.activity.recycler;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityRecyclerBinding;
import com.sananhaji.androidders.models.Student;

import java.util.Arrays;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    // 1
    private final List<Student> students = Arrays.asList(
            new Student(R.drawable.ic_success, "senan", "haci"),
            new Student(R.drawable.ic_success, "TURAL", "yusifli"),
            new Student(R.drawable.ic_success, "kerim", "aisis")
    );

    private ActivityRecyclerBinding binding;

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 12
        binding.studentList.setAdapter(adapter = new RecyclerAdapter());
        // 13
        binding.studentList.setLayoutManager(new LinearLayoutManager(this));

        adapter.setStudents(students);

        new Handler().postDelayed(() -> {
            adapter.setStudents(students);
        }, 3000);
        new Handler().postDelayed(() -> {
            adapter.setStudents(students);
        }, 6000);

        new Handler().postDelayed(() -> {
            adapter.setStudents(students);
        }, 9000);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}