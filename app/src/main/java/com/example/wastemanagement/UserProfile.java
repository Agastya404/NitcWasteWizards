package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Button myComplaints=findViewById(R.id.myComplaint);
        Button complaintStatus=findViewById(R.id.complaintStatus);
        Button registerComplaint=findViewById(R.id.registerComplaint);
        Button userLogout=findViewById(R.id.userLogout);



        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserProfile.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserProfile.this,MainActivity.class ));


            }
        });
        registerComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserProfile.this, PostComplaintPage.class));
            }
        });

        myComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}