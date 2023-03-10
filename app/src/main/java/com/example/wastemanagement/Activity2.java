package com.example.wastemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView username =(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);

        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);
        //admin and
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {

                    //correct
                    // Toast.makeText(MainActivity.this, "Login SUCCESFULLY",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //Toast.makeText(MainActivity.this, "Login failed!!!!",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}