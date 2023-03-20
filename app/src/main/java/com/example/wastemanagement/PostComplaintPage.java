package com.example.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostComplaintPage extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("UserComplaint");


    EditText username,comp_description;
    EditText area;
    EditText landmark;
    Button sendbtn;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_complaint_page);
        username=findViewById(R.id.username);
        comp_description = findViewById(R.id.writeincompliantbox);
        area = findViewById(R.id.complaintinarea);
        landmark= findViewById(R.id.complaintarealandmark);
        sendbtn = findViewById(R.id.send_complaint_button);

        sendbtn.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View v) {
                String uname=username.getText().toString();
                String complaint_des = comp_description.getText().toString();
                String complaint_area = area.getText().toString();
                String complaint_land = landmark.getText().toString();
                String str = comp_description.getText().toString();
                String area=comp_description.getText().toString();


                if (complaint_des.isEmpty() && complaint_area.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter the Complaint Description and Area", Toast.LENGTH_SHORT).show();
                }
                else if (complaint_des.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter the Complaint Description", Toast.LENGTH_SHORT).show();

                }
                else if (complaint_area.isEmpty())
                {
                    Toast.makeText(PostComplaintPage.this, "Please enter a Area", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // Create the Intent object of this class Context() to Second_activity class
                    Intent intent = new Intent(getApplicationContext(), ComplaintRegisterSuccessfully.class);

                    // now by putExtra method put the value in key, value pair key is
                    // message_key by this key we will receive the value, and put the string
                    intent.putExtra("message_key", str);
                    intent.putExtra("area",area);
                    // start the Intent
                    startActivity(intent);
                    complaint_by_userFirebase(uname,complaint_des,complaint_area,complaint_land);
                    Toast.makeText(PostComplaintPage.this, "Your complaint registered successfully", Toast.LENGTH_SHORT).show();


                }
            }
        });



    }
    private void complaint_by_userFirebase(String uname,String complaint_des, String complaint_area, String complaint_land)
    {

        UserComplaint usercomplaint= new UserComplaint(uname,complaint_des,complaint_area,complaint_land);
//        reference.child("UserComplaint").
        reference.child(reference.push().getKey().toString()).setValue(usercomplaint).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(PostComplaintPage.this, "posted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        };

}