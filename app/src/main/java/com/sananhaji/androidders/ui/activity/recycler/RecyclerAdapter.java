package com.sananhaji.androidders.ui.activity.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sananhaji.androidders.R;
import com.sananhaji.androidders.models.Student;

import java.util.ArrayList;
import java.util.List;
//                                   22222
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentViewHolder> {

    // 3
    List<Student> students = new ArrayList<>();

    // 10
    public void setStudents(List<Student> students) {
        // 11
        this.students.addAll(students);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 4
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.StudentViewHolder holder, int position) {
        // 6
        holder.onBind(students.get(position));
    }

    @Override
    public int getItemCount() {
        // 7
        return students.size();
    }

    // 1
    static class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView name, surname;
        private ImageView image;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            // 8
            name = itemView.findViewById(R.id.name);
            surname = itemView.findViewById(R.id.surname);
            image = itemView.findViewById(R.id.image);
        }

        // 5
        private void onBind(Student student) {
            // 9
            name.setText(student.getName());
            surname.setText(student.getSurname());
            image.setImageResource(student.getImageId());
        }
    }
}
