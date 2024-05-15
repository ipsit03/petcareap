package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OwnerprofileActivity extends AppCompatActivity {

    private TextView textViewStoreName, textViewPhoneNumber, textViewEmail;
    private DatabaseReference databaseReference;
    private Button btnshowmypet;
    private Button btnsignout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerprofile);

        textViewStoreName = findViewById(R.id.textViewStoreName);
        textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);
        textViewEmail = findViewById(R.id.textViewEmail);
        btnshowmypet=findViewById(R.id.button);
        btnsignout=findViewById(R.id.button3);
        btnshowmypet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OwnerprofileActivity.this,MypetActivity.class);
                startActivity(intent);

            }
        });
        btnsignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                signOutUser();
            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("My Profile");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {

                    String email = snapshot.child("edEmail").getValue(String.class);
                    String name = snapshot.child("edName").getValue(String.class);
                    String phoneNumber = snapshot.child("edPhonenumber").getValue(String.class);

                    textViewStoreName.setText(name);
                    textViewPhoneNumber.setText(phoneNumber);
                    textViewEmail.setText(email);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(OwnerprofileActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }

        });

    }
    public void signOutUser(){
        Intent intent=new Intent(OwnerprofileActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
