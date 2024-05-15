package com.example.petcareapp;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MypetActivity extends AppCompatActivity {
    private ListView listMypet;
    private Button btnShowmypet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypet);
        listMypet=findViewById(R.id.listviewMypet);
        btnShowmypet=(Button) findViewById(R.id.button2);
        btnShowmypet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> a=new ArrayList<>();
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MypetActivity.this,R.layout.items,a);
                listMypet.setAdapter(adapter);
                FirebaseDatabase.getInstance().getReference().child("MyPet").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            a.clear();;
                            for (DataSnapshot snapshot1:snapshot.getChildren()){
                                MyPet i=snapshot1.getValue(MyPet.class);
                                String t=i.getEdPetname()+':'+i.getEdPettype()+":"+i.getEdPetbreed();
                                a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}