package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        LinearLayout blogSection = view.findViewById(R.id.blogSection);
        LinearLayout doctorAppointmentSection = view.findViewById(R.id.doctorAppointmentSection);
        LinearLayout otherServicesSection = view.findViewById(R.id.otherServicesSection);

        blogSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BlogActivity.class));
            }
        });

        doctorAppointmentSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DoctorappointmentActivity.class));
            }
        });

        otherServicesSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OtherservicesActivity.class));
            }
        });
        return view;

    }
}