package com.example.wastemanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button userLogin;
    private Button adminLogin;
    private Button registerUser;
    private Button aboutUs;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userLogin=findViewById(R.id.userLogin);
        adminLogin=findViewById(R.id.adminLogin);
        registerUser =findViewById(R.id.registerUser);
        aboutUs=findViewById(R.id.aboutUs);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openAboutUs();
            }
        });
        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openUserLogin();
            }
        });
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {

                openAdminLogin();
            }
        });
        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View signs) {
                openSignUpPage();

            }
        });


    }

    private void openAboutUs(){
       Intent intent4=new Intent(this,AboutUsNext.class);
       startActivity(intent4);
    }
    private void openSignUpPage() {
        Intent intent3 =new Intent(this, SignUpPage.class);
        startActivity(intent3);
    }

    public void openUserLogin(){
        Intent intent =new Intent(this, UserLoginPage.class);
        startActivity(intent);

    }

    public void openAdminLogin(){
        Intent intent2 =new Intent(this, AdminActivity2.class);
        startActivity(intent2);
    }

}