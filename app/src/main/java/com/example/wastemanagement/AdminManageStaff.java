package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class AdminManageStaff extends AppCompatActivity {

  
    Button addStaff,updateStaff,showStaff;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage_staff);
        addStaff=findViewById(R.id.addstaff);
        updateStaff=findViewById(R.id.update_staff);
        showStaff=findViewById(R.id.showstaffdetail);
        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminManageStaff.this, "add staff here", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminManageStaff.this,AddStaff.class));
                finish();
            }
        });
        showStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminManageStaff.this, "View Staff", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminManageStaff.this,AdminStaffDetails.class));
                finish();
            }
        });

    }

}
