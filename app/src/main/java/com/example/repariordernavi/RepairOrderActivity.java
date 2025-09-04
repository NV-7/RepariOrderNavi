package com.example.repariordernavi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {

    Double number = 0.0;
    Button submitButton;
    View.OnClickListener buttonListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random gen = new Random();
            double ranNum = gen.nextDouble();
            TextView totalTV = findViewById(R.id.totalInput);
            totalTV.setText((String.valueOf(ranNum)));
            Toast.makeText(RepairOrderActivity.this, "Submitted", Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);

        Random gen = new Random();
        double ranNum = gen.nextDouble();
        TextView totalTV = findViewById(R.id.totalInput);
       // totalTV.setText((String.valueOf(ranNum)));
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(buttonListner);
        String value = totalTV.getText().toString();


        Log.i("TEST", value);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}