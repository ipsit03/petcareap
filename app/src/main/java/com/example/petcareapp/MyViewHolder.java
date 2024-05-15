package com.example.petcareapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageviewitem;
    TextView textviewitemname;
    TextView textviewitemprice;
    Button buttonitem;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageviewitem=itemView.findViewById(R.id.imageviewitem);
        textviewitemname=itemView.findViewById(R.id.textviewitemname);
        textviewitemprice=itemView.findViewById(R.id.textviewitemprice);
        buttonitem=itemView.findViewById(R.id.buttonitem);
    }
}
