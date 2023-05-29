package com.example.chatwiseassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    private CardView cardView;
    private LinearLayout expansionLayout;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button openActivityButton;

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.cardView);
        expansionLayout = findViewById(R.id.expansionLayout);
        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        openActivityButton = findViewById(R.id.openActivityButton);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleExpansion();
            }
        });

        openActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toggleExpansion() {
        if (isExpanded) {
            expansionLayout.setVisibility(View.GONE);
            titleTextView.setText("Click me");
            isExpanded = false;
        } else {
            expansionLayout.setVisibility(View.VISIBLE);
            titleTextView.setText("Click me (expanded)");
            isExpanded = true;
        }
    }
}
