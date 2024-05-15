package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;


public class MypetFragment extends Fragment {
    private ImageView imageMypets;
    private TextView textMypets;
    private ImageView imageAddpets;
    private TextView textAddpets;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mypet, container, false);
        imageMypets=view.findViewById(R.id.imageMypets);
        textMypets=view.findViewById(R.id.textMypets);
        imageAddpets=view.findViewById(R.id.imageAddpets);
        textAddpets=view.findViewById(R.id.textAddpets);
        imageMypets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MypetActivity.class);
                startActivity(intent);
            }
        });
        textMypets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MypetActivity.class);
                startActivity(intent);
            }
        });
        imageAddpets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AddpetActivity.class);
                startActivity(intent);
            }
        });
        textAddpets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AddpetActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}