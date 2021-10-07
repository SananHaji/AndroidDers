package com.sananhaji.androidders.ui.activity.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityPersonBinding;
import com.sananhaji.androidders.models.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonActivity extends AppCompatActivity {

    ActivityPersonBinding binding;
    PersonAdapter personAdapter;
    public static final List<Person> persons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(persons.isEmpty()) {
            persons.add(new Person("ertet", "fh", 23, "jhg"));
            persons.add(new Person("ertet", "fh", 23, "jhg"));
            persons.add(new Person("ertet", "fh", 23, "jhg"));
            persons.add(new Person("ertet", "fh", 23, "jhg"));
        }
        binding.personRecycler.setAdapter( personAdapter = new PersonAdapter());
        binding.personRecycler.setLayoutManager(new LinearLayoutManager(this));
        personAdapter.setPerson(persons);

        binding.buttonAdd.setOnClickListener(view -> {
            Intent intent = new Intent(this,AddPersonActivity.class);
            startActivity(intent);
        });
    }
}