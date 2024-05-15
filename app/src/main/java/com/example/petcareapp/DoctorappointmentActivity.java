package com.example.petcareapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class DoctorappointmentActivity extends AppCompatActivity {

    private EditText editTextPetName, editTextPetAge, editTextPetType;
    private Spinner spinnerDoctors;
    private Button buttonSelectDate, buttonBookAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorappointment);

        editTextPetName = findViewById(R.id.editTextPetName);
        editTextPetAge = findViewById(R.id.editTextPetAge);
        editTextPetType = findViewById(R.id.editTextPetType);
        spinnerDoctors = findViewById(R.id.spinnerDoctors);
        buttonSelectDate = findViewById(R.id.buttonSelectDate);
        buttonBookAppointment = findViewById(R.id.buttonBookAppointment);

        String[] doctors = {"Dr. Smith", "Dr. Johnson", "Dr. Brown", "Dr. Davis", "Dr. Miller"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, doctors);
        spinnerDoctors.setAdapter(adapter);

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        buttonBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookAppointment();
            }
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(DoctorappointmentActivity.this, "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void bookAppointment() {
        String petName = editTextPetName.getText().toString().trim();
        String petAge = editTextPetAge.getText().toString().trim();
        String petType = editTextPetType.getText().toString().trim();
        String selectedDoctor = spinnerDoctors.getSelectedItem().toString();

        String message = "Appointment booked for " + petName + " (Age: " + petAge + ", Type: " + petType + ") with " + selectedDoctor;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
