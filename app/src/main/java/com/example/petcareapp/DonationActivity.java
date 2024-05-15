package com.example.petcareapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class DonationActivity extends AppCompatActivity {

    private EditText editTextDonationAmount;
    private Spinner spinnerPetCharity;
    private Button buttonDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        editTextDonationAmount = findViewById(R.id.editTextDonationAmount);
        spinnerPetCharity = findViewById(R.id.spinnerPetCharity);
        buttonDonate = findViewById(R.id.buttonDonate);

        List<String> petCharities = new ArrayList<>();
        petCharities.add("Select Pet Charity");
        petCharities.add("Pet Charities");
        petCharities.add("All pet charity");
        petCharities.add("Pet society");
        ArrayAdapter<String> charityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, petCharities);
        charityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPetCharity.setAdapter(charityAdapter);

        buttonDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donate();
            }
        });
    }

    private void donate() {
        String donationAmountStr = editTextDonationAmount.getText().toString().trim();
        String selectedCharity = spinnerPetCharity.getSelectedItem().toString();

        if (donationAmountStr.isEmpty()) {
            Toast.makeText(this, "Please enter donation amount", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedCharity.equals("Select Pet Charity")) {
            Toast.makeText(this, "Please select a pet charity", Toast.LENGTH_SHORT).show();
            return;
        }

        double donationAmount = Double.parseDouble(donationAmountStr);

        String message = "Thank you for donating $" + donationAmount + " to " + selectedCharity + "!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        finish();
    }
}
