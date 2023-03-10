package com.example.wastemanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button3;
    private Button button;
    private Button button2;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button= (Button) findViewById(R.id.button);
        button3=(Button) findViewById(R.id.button3);
        button2=(Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                adminActivityopen();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View signs) {
                openSignUpPage();

            }
        });

    }

    private void openSignUpPage() {
        Intent intent3 =new Intent(this, SignUpPage.class);
        startActivity(intent3);
    }

    public void openActivity2(){
        Intent intent =new Intent(this, Activity2.class);
        startActivity(intent);

    }

    public void adminActivityopen(){
        Intent intent2 =new Intent(this, AdminActivity2.class);
        startActivity(intent2);
    }
}