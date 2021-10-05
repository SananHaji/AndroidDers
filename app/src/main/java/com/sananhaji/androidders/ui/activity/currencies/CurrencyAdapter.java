package com.sananhaji.androidders.ui.activity.currencies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.models.Currency;

import java.util.ArrayList;
import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder> {
    List<Currency> currencies = new ArrayList<>();

    public void setCurrencies(List<Currency> currencies) {
        this.currencies.addAll(currencies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CurrencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);
        return new CurrencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.CurrencyViewHolder holder, int position) {
        holder.onBind(currencies.get(position));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    protected static class CurrencyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, value;
        private ImageView imageView;

        public CurrencyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            value = itemView.findViewById(R.id.value);
            imageView = itemView.findViewById(R.id.image);
        }

        private void onBind(Currency currency) {

            name.setText(currency.getName());
            value.setText(String.valueOf(currency.getValue()));
            imageView.setImageResource(currency.getImageId());


        }
    }
}
