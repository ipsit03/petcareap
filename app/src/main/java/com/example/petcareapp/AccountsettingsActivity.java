package com.example.petcareapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountsettingsActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber, editTextEmail;
    private Button buttonSaveChanges;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("My Profile");

        buttonSaveChanges.setOnClickListener(view -> saveChanges());
    }

    private void saveChanges() {

        String newPhoneNumber = editTextPhoneNumber.getText().toString().trim();
        String newEmail = editTextEmail.getText().toString().trim();

        databaseReference.child("edPhonenumber").setValue(newPhoneNumber);
        databaseReference.child("edEmail").setValue(newEmail);

        Toast.makeText(this, "Changes saved successfully", Toast.LENGTH_SHORT).show();
    }
}
