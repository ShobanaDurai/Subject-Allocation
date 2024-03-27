package com.example.subjectallocation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList course_id,subject_id,faculty_id,subcode_id,Class_id;

    public MyAdapter(Context context, ArrayList course_id, ArrayList subject_id, ArrayList faculty_id, ArrayList subcode_id,ArrayList Class_id) {
        this.context = context;
        this.course_id = course_id;
        this.subject_id = subject_id;
        this.faculty_id = faculty_id;
        this.subcode_id = subcode_id;
        this.Class_id = Class_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.course_id.setText(String.valueOf(course_id.get(position)));
        holder.subject_id.setText(String.valueOf(subject_id.get(position)));
        holder.subcode_id.setText(String.valueOf(subcode_id.get(position)));
        holder.Class_id.setText(String.valueOf(Class_id.get(position)));
        holder.faculty_id.setText(String.valueOf(faculty_id.get(position)));

    }

    @Override
    public int getItemCount() {
        return course_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView course_id,subject_id,faculty_id,subcode_id,Class_id;
        Button edit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course_id = itemView.findViewById(R.id.textViewCourse);
            subject_id = itemView.findViewById(R.id.textViewSubject);
            subcode_id = itemView.findViewById(R.id.textViewSubjectCode);
            Class_id = itemView.findViewById(R.id.textViewClass);
            faculty_id = itemView.findViewById(R.id.textViewFaculty);
            edit=(Button)itemView.findViewById(R.id.buttonUpdate);
        }
    }
}
