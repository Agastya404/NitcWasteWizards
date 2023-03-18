package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class AdminDashboardPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard_page);


        Button adminComplaint =findViewById(R.id.adminComplaint);
        Button adminStaff = findViewById(R.id.adminStaff);
        Button adminLogout = findViewById(R.id.adminLogout);

        adminComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminDashboardPage.this, "opening Complaint page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminDashboardPage.this, AdminComplaint.class ));
                finish();
            }
        });

        adminStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminDashboardPage.this, "Opening manage Staff page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminDashboardPage.this,AdminManageStaff.class ));
            }
        });
        adminLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdminDashboardPage.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminDashboardPage.this,MainActivity.class ));

            }
        });
    }

}