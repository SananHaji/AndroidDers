package com.sananhaji.androidders.ui.activity.person;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityAddPersonBinding;
import com.sananhaji.androidders.databinding.ActivityPersonBinding;
import com.sananhaji.androidders.models.Person;

public class AddPersonActivity extends AppCompatActivity {

    ActivityAddPersonBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddPersonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonAddPerson.setOnClickListener(view -> {
            String name = binding.editTextName.getText().toString();
            String surname = binding.editTextSurname.getText().toString();
            int age = Integer.parseInt(binding.editTextAge.getText().toString());
            String job = binding.editTextJob.getText().toString();

            Person person = new Person(name, surname, age, job);
            PersonActivity.persons.add(person);

            Intent intent = new Intent(this, PersonActivity.class);
            startActivity(intent);
        });
    }
}