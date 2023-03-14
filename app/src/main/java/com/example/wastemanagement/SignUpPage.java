package com.example.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpPage extends AppCompatActivity {

    FirebaseAuth auth = FirebaseAuth.getInstance();


    EditText username,email,password;
    Button signUp;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    FirebaseUser user = auth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        username = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signUp = findViewById(R.id.button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmailId = email.getText().toString();
                String userPassword = password.getText().toString();

                if (userEmailId.isEmpty() && userPassword.isEmpty())
                {
                    Toast.makeText(SignUpPage.this, "Please enter the Email id and Password", Toast.LENGTH_SHORT).show();
                }
                else if (userEmailId.isEmpty())
                {
                    Toast.makeText(SignUpPage.this, "Please enter a Email id", Toast.LENGTH_SHORT).show();

                }
                else if (userPassword.isEmpty())
                {
                    Toast.makeText(SignUpPage.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                }
                else if (Patterns.EMAIL_ADDRESS.matcher(userEmailId).matches()) {
                    boolean check = checkNitcEmail(userEmailId);
                    if (check)
                       // System.out.println("inside check ");
                        signUpFirebase(userEmailId, userPassword);
                    else
                        Toast.makeText(SignUpPage.this, "Enter NITC email id", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(SignUpPage.this, "Please enter a valid email id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean checkNitcEmail(String userEmailId)
    {
        String[] emailid = userEmailId.split("@");
        if(emailid[1].equals("nitc.ac.in"))
            return true;
        return false;
    }

    private void signUpFirebase(String userEmailId, String userPassword) {

        auth.createUserWithEmailAndPassword(userEmailId,userPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUpPage.this, "Your account is created successfully", Toast.LENGTH_LONG).show();
                            UserDetails user = new UserDetails(username.getText().toString(), email.getText().toString(), password.getText().toString());
                            reference.child("User").child(auth.getCurrentUser().getUid()).setValue(user);

                            Intent intent = new Intent(SignUpPage.this, UserLoginPage.class);
                            startActivity(intent);
                            finish();
                        }
                        else
                        {
                            if(task.getException() instanceof FirebaseAuthUserCollisionException)
                            {
                                Toast.makeText(SignUpPage.this, "This email id is already present", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(SignUpPage.this, "There is a problem, Please try after sometime", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            signUp.setClickable(true);
                        }
                    }
                });
    }





    }
