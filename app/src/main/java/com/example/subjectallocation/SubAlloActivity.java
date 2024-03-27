package com.example.subjectallocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubAlloActivity extends AppCompatActivity {
    EditText course,subcode,subject,faculty,Class;
    Button add,view,update,delete;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_allo);
        course=findViewById(R.id.editTextCourse);
        subject=findViewById(R.id.editTextSubject);
        subcode=findViewById(R.id.editTextSubjectCode);
        faculty=findViewById(R.id.editTextFaculty);
        Class=findViewById(R.id.editTextClass);
        add=findViewById(R.id.buttonAdd);
        view=findViewById(R.id.buttonView);
        update=findViewById(R.id.buttonUpdate);
        delete=findViewById(R.id.buttonDelete);

        DB = new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubAlloActivity.this,Userlist.class));

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseTXT = course.getText().toString();
                String subjectTXT = subject.getText().toString();
                String facultyTXT = faculty.getText().toString();
                String subcodeTXT = subcode.getText().toString();
                String ClassTXT = Class.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(courseTXT, subjectTXT, facultyTXT, subcodeTXT, ClassTXT);
                    if (checkinsertdata == true) {
                        Toast.makeText(SubAlloActivity.this, "New Record Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SubAlloActivity.this, "New Record Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }

        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String courseTXT = course.getText().toString();
                String subjectTXT = subject.getText().toString();
                String facultyTXT = faculty.getText().toString();
                String subcodeTXT = subcode.getText().toString();
                String ClassTXT = Class.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(courseTXT,subjectTXT,facultyTXT,subcodeTXT,ClassTXT);
                if(checkupdatedata==true) {
                    Toast.makeText(SubAlloActivity.this,"Record Updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SubAlloActivity.this,"Record Not Updated",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjectTXT = subject.getText().toString();

                Boolean checkdeletedata = DB.deleteuserdata(subjectTXT);
                if(checkdeletedata==true) {
                    Toast.makeText(SubAlloActivity.this,"Record Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SubAlloActivity.this,"Record Not Deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
}
}
