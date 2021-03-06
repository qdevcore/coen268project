package edu.scu.coen268.fetch;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    public double searchRadiusMiles = 1;
    public List<String> feedbackAndHelpList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);
    }

    public void walkingDistance(View view) {
        searchRadiusMiles = 1;
    }

    public void bikingDistance(View view) {
        searchRadiusMiles = 4;
    }

    public void drivingDistance(View view) {
        searchRadiusMiles = 8;
    }

    public void helpAndFeedback(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("We welcome your feedback and questions");
        EditText editText = new EditText(this);
        builder.setView(editText);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newItem = editText.getText().toString();
                feedbackAndHelpList.add(newItem);
                Toast.makeText(SettingsActivity.this, "Thank you!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // ignore
            }
        });

        builder.show();
    }

    public void termsAndConditions(View view) {
        Intent intent = new Intent(this, TermsAndConditionsActivity.class);
        startActivity(intent);
    }
}
