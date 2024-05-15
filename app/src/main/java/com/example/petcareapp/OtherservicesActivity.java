package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class OtherservicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherservices);
        LinearLayout veterinarysection=findViewById(R.id.veterinarySection);
        LinearLayout shopsection=findViewById(R.id.shopSection);
        LinearLayout donationSection=findViewById(R.id.donationSection);
        veterinarysection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherservicesActivity.this,DoctorappointmentActivity.class);
                startActivity(intent);
            }
        });
        shopsection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherservicesActivity.this,PetshopActivity.class);
                startActivity(intent);
            }
        });
        donationSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherservicesActivity.this,DonationActivity.class);
                startActivity(intent);
            }
        });
    }
}