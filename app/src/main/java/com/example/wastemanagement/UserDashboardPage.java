package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserDashboardPage extends AppCompatActivity {

    Button lodgeComplaint;
    Button viewComplaint;
    Button viewStatus;

    Button userLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard_page);


        lodgeComplaint=findViewById(R.id.lodgeComplaint);
        viewComplaint=findViewById(R.id.viewComplaints);
        viewStatus=findViewById(R.id.viewSatuts);
        userLogout=findViewById(R.id.userLogout);

        lodgeComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserDashboardPage.this, PostComplaintPage.class));
            }
        });
        userLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserDashboardPage.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDashboardPage.this,MainActivity.class ));

            }
        });


    }
}