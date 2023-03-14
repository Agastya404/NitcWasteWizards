package com.example.wastemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import javax.security.auth.login.LoginException;

public class UserLoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userloginpage);
        final EditText username =findViewById(R.id.username);
        final EditText password= findViewById(R.id.password);
        final Button loginBtn=findViewById(R.id.loginBtn);
        final TextView signupButton=findViewById(R.id.signup);
        FirebaseAuth auth = FirebaseAuth.getInstance();


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nitc-waste-management-4e478-default-rtdb.firebaseio.com/");


        MaterialButton loginBn=(MaterialButton) findViewById(R.id.loginBtn);
        //admin and
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            final String usernameTxt=username.getText().toString();
            final String passwordTxt=password.getText().toString();

            if(usernameTxt.isEmpty() || passwordTxt.isEmpty())
            {
                Toast.makeText(UserLoginPage.this,"please enter your username and password",Toast.LENGTH_SHORT).show();
            }
            else{
                databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //check if username is exist in firebase datbase
                        if(snapshot.hasChild(usernameTxt)) {
                            //usernaem is exist in firebase database
                            //now get password of user from firebasse data and match it with user entered password

                            final String getPassword = snapshot.child(usernameTxt).child("password").getValue(String.class);

//                            if (getPassword.equals(passwordTxt)) {
//                                Toast.makeText(UserLoginPage.this, "Sucessfully logged in ", Toast.LENGTH_SHORT).show();
//                                //open MAinActivity on success
//                                startActivity(new Intent(UserLoginPage.this, MainActivity.class));
//                                finish();
//                            }
                            auth.signInWithEmailAndPassword(usernameTxt, passwordTxt).addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(UserLoginPage.this, MainActivity.class));
                                } else {
                                    Toast.makeText(UserLoginPage.this,
                                            "Please Check Your login Credentials",
                                            Toast.LENGTH_SHORT).show();
                                }

                            });


//                            else {
//                                Toast.makeText(UserLoginPage.this, "wrong passwrod", Toast.LENGTH_SHORT).show();
//                            }
                        }
                            else{
                                Toast.makeText(UserLoginPage.this,"Wrong username",Toast.LENGTH_SHORT).show();
                            }
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openn register actitvty
                //startActivity(new Intent(UserLoginPage.this, signupButton.class));
            }
        });
    }
}