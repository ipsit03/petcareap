package com.example.petcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PetshopActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ShopAdapter adapter;
    private List<item> itemList;
    private ImageView imageview14, imageview15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petshop);

        recyclerView = findViewById(R.id.recyclerviewitem);
        imageview14=findViewById(R.id.imageView14);
        imageview15=findViewById(R.id.imageView15);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new item("Dog Protein", "120", R.drawable.petcareap12));
        itemList.add(new item("Protein for all", "200", R.drawable.petcareap13));
        itemList.add(new item("Pedigreee","209",R.drawable.petcareap14));
        itemList.add(new item("Cat protein","117",R.drawable.petcareap15));
        itemList.add(new item("Protein for all","207",R.drawable.petcareap16));
        itemList.add(new item("Fish protein","109",R.drawable.petcareap17));
        itemList.add(new item("Bird protein","207",R.drawable.petcareap18));
        itemList.add(new item("Cereal for all","111",R.drawable.petcareap19));
        itemList.add(new item("Dog toy","217",R.drawable.petcareap20));
        itemList.add(new item("Toy for all","109",R.drawable.petcareap21));

        adapter = new ShopAdapter(this, itemList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(item item) {
                // Handle item click here, for example, start BuyActivity
                Intent intent = new Intent(PetshopActivity.this, BuyActivity.class);
                intent.putExtra("itemName", item.getName());
                intent.putExtra("itemPrice", item.getPrice());
                startActivity(intent);
            }
        });
        imageview14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PetshopActivity.this,BuyActivity.class);
                startActivity(intent);
            }
        });
        imageview15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PetshopActivity.this,OwnerprofileActivity.class);
                startActivity(intent);
            }
        });
    }
}
