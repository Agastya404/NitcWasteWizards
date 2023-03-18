package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ComplaintReggisterSuccessfully extends AppCompatActivity {

    TextView complaintDetail;
    TextView area;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complaint_reggister_successfully);
        complaintDetail = findViewById(R.id.complaintDetail);
        area=findViewById(R.id.complaintinarea);
        // create the get Intent object
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String str = intent.getStringExtra("message_key");
        String str2=intent.getStringExtra("area");
        // display the string into textView
        complaintDetail.setText(str);
    }
}