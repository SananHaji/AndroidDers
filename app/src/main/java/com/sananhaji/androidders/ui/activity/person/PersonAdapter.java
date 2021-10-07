package com.sananhaji.androidders.ui.activity.person;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    List<Person> personList = new ArrayList<>();

    public void setPerson(List<Person> person){
        this.personList.addAll(person);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.onBind(personList.get(position));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView name, surname, age, job;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            age = itemView.findViewById(R.id.age);
            job = itemView.findViewById(R.id.job);
        }

        private void onBind(Person person) {
            name.setText(person.getNme());
            surname.setText(person.getSurname());
            age.setText(String.valueOf(person.getAge()));
            job.setText(person.getJob());
        }
    }
}

