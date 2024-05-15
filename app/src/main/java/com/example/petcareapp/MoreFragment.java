package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class MoreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_more,container,false);
        RelativeLayout layoutOwnerProfile=view.findViewById(R.id.layoutOwnerProfile);
        RelativeLayout layoutDonation=view.findViewById(R.id.layoutDonation);
        RelativeLayout layoutAccountSettings=view.findViewById(R.id.layoutAccountSettings);
        RelativeLayout layoutHelpCenter=view.findViewById(R.id.layoutHelpCenter);
        layoutOwnerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OwnerprofileActivity.class);
                startActivity(intent);
            }
        });
        layoutDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DonationActivity.class);
                startActivity(intent);
            }
        });
        layoutAccountSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AccountsettingsActivity.class);
                startActivity(intent);
            }
        });
        layoutHelpCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HelpcenterActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}