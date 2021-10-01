package com.sananhaji.androidders.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityToolbarBinding;

public class ToolbarActivity extends AppCompatActivity {

    ActivityToolbarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sing:
                Toast.makeText(this, "sing", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.read:
                Toast.makeText(this, "read", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item:
                Toast.makeText(this, "item", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}