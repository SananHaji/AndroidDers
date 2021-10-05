package com.sananhaji.androidders.ui.activity.currencies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.databinding.ActivityCurrenciesBinding;
import com.sananhaji.androidders.models.Currency;

import java.util.Arrays;
import java.util.List;

public class CurrenciesActivity extends AppCompatActivity {
    ActivityCurrenciesBinding binding;
    CurrencyAdapter adapter;
    List<Currency> currencyList = Arrays.asList(
            new Currency(R.drawable.ic_success, "asdasd", 5),
            new Currency(R.drawable.ic_success, "asdasd", 5),
            new Currency(R.drawable.ic_success, "asdasd", 5)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCurrenciesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.currencies.setAdapter(adapter = new CurrencyAdapter());
        binding.currencies.setLayoutManager(new LinearLayoutManager(this));
        adapter.setCurrencies(currencyList);
    }
}