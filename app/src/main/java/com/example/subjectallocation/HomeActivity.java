package com.example.subjectallocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_SHORT).show();

        CardView allocation = findViewById(R.id.cardAllocation);
        allocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,AllocationActivity.class));
            }
        });
        CardView course = findViewById(R.id.cardCourse);
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,CourseActivity.class));
            }
        });
        CardView subject = findViewById(R.id.cardSubject);
        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SubjectActivity.class));
            }
        });
        CardView faculty = findViewById(R.id.cardFaclty);
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FacultyActivity.class));
            }
        });

    }
}