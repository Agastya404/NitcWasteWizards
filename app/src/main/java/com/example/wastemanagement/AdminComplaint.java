package com.example.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminComplaint extends AppCompatActivity {

    private RecyclerView  recyclerView;
    TextView viewComplaint;
//    Button approve,disapprove;
    ArrayList<UserComplaint> usercomplaint = new ArrayList<UserComplaint>();
    adminAdapter adminAdapter;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AdminComplaint.this,AdminDashboardPage.class));
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_complaint);
        viewComplaint=findViewById(R.id.viewComplaint);
        recyclerView=findViewById(R.id.adminComplaintRV);
//        approve=findViewById(R.id.approveBtn);
//        disapprove=findViewById(R.id.disapproveBtn);
//        approve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(AdminComplaint.this, "Complaint approved!", Toast.LENGTH_SHORT).show();
//            }
//        });
//        disapprove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(AdminComplaint.this, "Complaint Disapproved!", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("UserComplaint");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Log.d("snap",dataSnapshot.toString());
                    UserComplaint complaint =dataSnapshot.getValue(UserComplaint.class);
                    usercomplaint.add(complaint);

                }
                adminAdapter = new adminAdapter(getApplicationContext(),usercomplaint);
                recyclerView.setAdapter(adminAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}