package com.example.lab3formulaireetnavigationentreactivits;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultDisplay;
    private Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Connect variables to screen elements
        resultDisplay = findViewById(R.id.displayData);
        returnButton = findViewById(R.id.backBtn);

        // Get the data sent from MainActivity
        Intent receivedIntent = getIntent();

        // Extract each piece of data using the same keys
        String userName = receivedIntent.getStringExtra("NAME_KEY");
        String userEmail = receivedIntent.getStringExtra("EMAIL_KEY");
        String userPhone = receivedIntent.getStringExtra("PHONE_KEY");
        String userAddress = receivedIntent.getStringExtra("ADDRESS_KEY");
        String userCity = receivedIntent.getStringExtra("CITY_KEY");

        // Handle empty values - show "Not provided" if something is empty
        if (userPhone == null || userPhone.isEmpty()) userPhone = "Not provided";
        if (userAddress == null || userAddress.isEmpty()) userAddress = "Not provided";
        if (userCity == null || userCity.isEmpty()) userCity = "Not provided";

        // Create the text to display
        String displayText = "━━━━━━━━━━━━━━━━━━━━━━\n" +
                "     REGISTRATION INFO     \n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Name: " + userName + "\n\n" +
                "Email: " + userEmail + "\n\n" +
                "Phone: " + userPhone + "\n\n" +
                "Address: " + userAddress + "\n\n" +
                "City: " + userCity + "\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━\n" +
                "✓ Form submitted successfully";

        // Show the text on screen
        resultDisplay.setText(displayText);

        // When user clicks Back button, close this screen
        returnButton.setOnClickListener(view -> {
            finish(); // This returns to MainActivity
        });
    }
}