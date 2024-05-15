package com.example.petcareapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BlogActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextContent;
    private Button buttonPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonPublish = findViewById(R.id.buttonPublish);

        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publishBlogPost();
            }
        });
    }

    private void publishBlogPost() {
        String title = editTextTitle.getText().toString().trim();
        String content = editTextContent.getText().toString().trim();

        String message = "Title: " + title + "\nContent: " + content;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
