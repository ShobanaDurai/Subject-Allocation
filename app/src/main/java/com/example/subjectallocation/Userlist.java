package com.example.subjectallocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> course,subject,subcode,Class,faculty;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        DB = new DBHelper(this);
        course = new ArrayList<>();
        subject = new ArrayList<>();
        subcode = new ArrayList<>();
        Class = new ArrayList<>();
        faculty = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new MyAdapter(this,course,subject,subcode,Class,faculty);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(Userlist.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext())
            {
                course.add(cursor.getString(0));
                subject.add(cursor.getString(1));
                subcode.add(cursor.getString(2));
                Class.add(cursor.getString(3));
                faculty.add(cursor.getString(4));
            }
        }
    }
}