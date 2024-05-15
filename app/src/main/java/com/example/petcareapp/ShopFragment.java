package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ShopFragment extends Fragment {
    private ImageView imagePetshop;
    private TextView textPetshop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_shop, container, false);
        imagePetshop=view.findViewById(R.id.imagePetshop);
        textPetshop=view.findViewById(R.id.textPetshop);
        imagePetshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PetshopActivity.class);
                startActivity(intent);
            }
        });
        textPetshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PetshopActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}