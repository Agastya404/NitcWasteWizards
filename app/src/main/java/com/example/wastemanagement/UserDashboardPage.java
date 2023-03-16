package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDashboardPage extends AppCompatActivity {

    Button lodgeComplaint;
    Button viewComplaint;
    Button viewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard_page);


        lodgeComplaint=findViewById(R.id.lodgeComplaint);
        viewComplaint=findViewById(R.id.viewComplaints);
        viewStatus=findViewById(R.id.viewSatuts);

        lodgeComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(UserDashboardPage.this, PostComplaintPage.class));
            }
        });


    }
}