package com.example.lab3formulaireetnavigationentreactivits;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Create variables for our input boxes
    private EditText inputName, inputEmail, inputPhone, inputAddress, inputCity;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect variables to the input fields on screen
        inputName = findViewById(R.id.nameField);
        inputEmail = findViewById(R.id.emailField);
        inputPhone = findViewById(R.id.phoneField);
        inputAddress = findViewById(R.id.addressField);
        inputCity = findViewById(R.id.cityField);
        sendButton = findViewById(R.id.submitBtn);

        // What happens when user clicks Submit button
        sendButton.setOnClickListener(view -> {

            // Get text from all fields and remove extra spaces
            String personName = inputName.getText().toString().trim();
            String personEmail = inputEmail.getText().toString().trim();
            String personPhone = inputPhone.getText().toString().trim();
            String personAddress = inputAddress.getText().toString().trim();
            String personCity = inputCity.getText().toString().trim();

            // Check if required fields (Name and Email) are filled
            if (TextUtils.isEmpty(personName)) {
                inputName.setError("Name is required");
                return;
            }

            if (TextUtils.isEmpty(personEmail)) {
                inputEmail.setError("Email is required");
                return;
            }

            // Create intent to go to second screen
            Intent goToResult = new Intent(MainActivity.this, ResultActivity.class);

            // Send data to next screen
            goToResult.putExtra("NAME_KEY", personName);
            goToResult.putExtra("EMAIL_KEY", personEmail);
            goToResult.putExtra("PHONE_KEY", personPhone);
            goToResult.putExtra("ADDRESS_KEY", personAddress);
            goToResult.putExtra("CITY_KEY", personCity);

            // Start the second screen
            startActivity(goToResult);
        });
    }
}