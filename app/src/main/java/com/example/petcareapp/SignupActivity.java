package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    private EditText edUsername, edPassword, edName, edPhonenumber;
    private Button btnLogin1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mPostDatabase;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edUsername=findViewById(R.id.edUsername);
        edPassword=findViewById(R.id.Password);
        btnLogin1=findViewById(R.id.btnLogin1);
        edName=findViewById(R.id.editTextText4);
        edPhonenumber=findViewById(R.id.editTextText5);
        mAuth=FirebaseAuth.getInstance();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        mPostDatabase=database.getReference().child("My Profile");
        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(edName.getText().toString())&&!TextUtils.isEmpty(edPhonenumber.getText().toString())&&!TextUtils.isEmpty(edUsername.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
                    String email = edUsername.getText().toString();
                    String password = edPassword.getText().toString();
                    CreateaccountFn(email, password);
                    addNameToDatabase();
                    edName.setText("");
                    edPhonenumber.setText("");
                    edUsername.setText("");
                } else
                {
                    Toast.makeText(SignupActivity.this,"enter your login username nad password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void CreateaccountFn(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignupActivity.this,"sign in successed",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(SignupActivity.this,"sign in failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void addNameToDatabase(){
        String name=edName.getText().toString();
        String phonenumber=edPhonenumber.getText().toString();
        String username=edUsername.getText().toString();
        MyProfile myprofile=new MyProfile(name, phonenumber, username);
        mPostDatabase.push().setValue(myprofile);
    }
}