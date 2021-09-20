package com.sananhaji.androidders;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sananhaji.androidders.models.Student;

import java.util.ArrayList;
import java.util.List;

import static com.sananhaji.androidders.utils.Constants.STUDENT_LIST_KEY;

public class StudentListActivity extends AppCompatActivity {
    private static final String TAG = "StudentListActivity";
    TextView textView;
    EditText name, surname;
    Button addStudent;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private List<Student> students;
    private String studentString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        textView = findViewById(R.id.textView);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        addStudent = findViewById(R.id.add_student);

        preferences = getSharedPreferences("lastPreferences", MODE_PRIVATE);
        editor = preferences.edit();

        String studentStr = preferences.getString(STUDENT_LIST_KEY, "");
        students = new Gson().fromJson(studentStr, new TypeToken<List<Student>>() {
        }.getType());
        if (students == null) {
            students = new ArrayList<>();
        }

        setList(students);

//        Log.d(TAG, "onCreate: " + studentStr);
//        Log.d(TAG, "onCreate: " + students);

//        textView.setText(getIntent().getStringExtra(STUDENT_LIST_NAME));


        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra(STUDENT_ACTIVITY_RESULT, name.getText().toString());
//
//                if (!name.getText().toString().equals(""))
//                    setResult(RESULT_OK, returnIntent);
//                else
//                    setResult(RESULT_CANCELED, returnIntent);
//                finish();
                Student student = new Student(name.getText().toString(), surname.getText().toString());
                students.add(student);
                showList(students);
            }
        });

    }

    private void showList(List<Student> students) {
        editor.putString(STUDENT_LIST_KEY, new Gson().toJson(students));
        editor.apply();
        setList(students);
    }

    private void setList(List<Student> students) {
        if (students != null) {
            studentString = "";
            for (Student student : students) {
                studentString = studentString.concat(student.getName()).concat(" ").concat(student.getSurname()).concat("\n");
            }
            textView.setText(studentString);
        }
    }
}