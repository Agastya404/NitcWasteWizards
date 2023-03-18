package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStaff extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();


    EditText staff_name;
    EditText staff_phone;
    EditText staff_emailid;
    EditText work_location;
    Button addbtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        staff_name = findViewById(R.id.staffname);
        staff_phone = findViewById(R.id.editphone);
        staff_emailid = findViewById(R.id.editemail);
        work_location = findViewById(R.id.editlocation);
        addbtn = findViewById(R.id.addstaff);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sta_name = staff_name.getText().toString();
                String sta_phone = staff_phone.getText().toString();
                String sta_emailid = staff_emailid.getText().toString();
                String wo_location = work_location.getText().toString();

                if (sta_name.isEmpty() && sta_phone.isEmpty() && sta_emailid.isEmpty() && wo_location.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please enter the Name, phone number,email-Id and Location", Toast.LENGTH_SHORT).show();
                } else if (sta_name.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please enter the Staff Name", Toast.LENGTH_SHORT).show();

                } else if (sta_phone.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please enter phone Number", Toast.LENGTH_SHORT).show();
                } else if (sta_emailid.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please enter email Id", Toast.LENGTH_SHORT).show();
                } else if (wo_location.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please enter Location", Toast.LENGTH_SHORT).show();
                } else if (sta_name.isEmpty() || sta_phone.isEmpty() || sta_emailid.isEmpty() || wo_location.isEmpty()) {
                    Toast.makeText(AddStaff.this, "Please check your input", Toast.LENGTH_SHORT).show();
                } else {


                    Add_staff_to_Firebase(sta_name, sta_phone, sta_emailid, wo_location);
                    Toast.makeText(AddStaff.this, "New Worker Added Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddStaff.this, AdminManageStaff.class));


                }
            }


            private void Add_staff_to_Firebase(String staff_name, String staff_phone, String staff_emailid, String work_location) {
                AddNewStaff addnewstaff = new AddNewStaff(staff_name, staff_phone, staff_emailid, work_location);
                reference.child("AddNewStaff").push().setValue(addnewstaff);
            }
        });
    }
}
