package com.example.petcareapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class BuyActivity extends AppCompatActivity {

    private TextView textViewItemName, textViewItemPrice, textViewTotalPrice, textViewDeliveryDate;
    private EditText editTextAddress;
    private RadioGroup radioGroupPaymentMode;
    private Button buttonConfirmPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        textViewItemName = findViewById(R.id.textViewItemName);
        textViewItemPrice = findViewById(R.id.textViewItemPrice);
        editTextAddress = findViewById(R.id.editTextAddress);
        radioGroupPaymentMode = findViewById(R.id.radioGroupPaymentMode);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);
        buttonConfirmPurchase = findViewById(R.id.buttonConfirmPurchase);
        textViewDeliveryDate = findViewById(R.id.textviewdeliverydate);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String itemName = extras.getString("itemName");
            String itemPrice = extras.getString("itemPrice");

            textViewItemName.setText(itemName);
            textViewItemPrice.setText("Price: $" + itemPrice);

            String randomDeliveryDate = generateRandomDeliveryDate();
            textViewDeliveryDate.setText(randomDeliveryDate);

            double price = Double.parseDouble(itemPrice);
            textViewTotalPrice.setText("Total Price: $" + price);
        }

        buttonConfirmPurchase.setOnClickListener(v -> confirmPurchase());
    }

    private String generateRandomDeliveryDate() {
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();

        int daysToAdd = random.nextInt(7) + 1;
        calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }

    private void confirmPurchase() {

        RadioButton selectedRadioButton = findViewById(radioGroupPaymentMode.getCheckedRadioButtonId());
        String paymentMode = selectedRadioButton.getText().toString();

        String deliveryDate = textViewDeliveryDate.getText().toString();

        String address = editTextAddress.getText().toString().trim();

        String confirmationMessage = "Purchase confirmed!\nPayment Mode: " + paymentMode +
                "\nDelivery Date: " + deliveryDate + "\nDelivery Address: " + address;
        Toast.makeText(this, confirmationMessage, Toast.LENGTH_LONG).show();
    }
}
