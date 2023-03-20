package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class UserDashboardPage extends AppCompatActivity {

    Button lodgeCBtn,viewCBtn,viewSBtn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard_page);
        lodgeCBtn=findViewById(R.id.lodgeCBtn);
        viewCBtn=findViewById(R.id.viewCBtn);
        viewSBtn=findViewById(R.id.viewSBtn);
        lodgeCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserDashboardPage.this, "post your complain here!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDashboardPage.this, PostComplaintPage.class));
                finish();
            }
        });
        viewCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserDashboardPage.this, "See your complain here!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDashboardPage.this,UserViewComplaint.class));
                finish();
            }
        });
        viewSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserDashboardPage.this, "See your complain here!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserDashboardPage.this,UserViewStatus.class));
                finish();
            }
        });


    }
}