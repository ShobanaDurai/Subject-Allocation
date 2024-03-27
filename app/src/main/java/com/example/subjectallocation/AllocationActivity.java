package com.example.subjectallocation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation);

        CardView suballodet = findViewById(R.id.cardSubAlloDet);
        suballodet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllocationActivity.this,Userlist.class));
            }
        });
        CardView suballo = findViewById(R.id.cardSubAllo);
        suballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllocationActivity.this, SubAlloActivity.class));
            }
        });
    }
}