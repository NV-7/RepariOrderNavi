package com.example.repariordernavi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {

    TextView subtotalTV;
    TextView taxTV;
    TextView totalTV;
    Button submitButton;
    EditText orderET;
    EditText technitianET;
    EditText laborET;
    EditText partET;
    EditText paintET;
    EditText inspectionET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);

        totalTV = findViewById(R.id.totalInput);
        subtotalTV = findViewById(R.id.subtotalInput);
        taxTV = findViewById(R.id.taxinput);
        orderET = findViewById(R.id.orderInput);
        technitianET = findViewById(R.id.technititanInput);
        laborET = findViewById(R.id.laborInput);
        partET = findViewById(R.id.partInput);
        paintET = findViewById(R.id.paintInput);
        inspectionET = findViewById(R.id.inspectioninput);

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

    View.OnClickListener buttonListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Random gen = new Random();
            double tax = 100*gen.nextDouble();
            double subtotal = 100*gen.nextDouble();
            double total = tax + subtotal;

//            totalTV = findViewById(R.id.totalInput);
//            subtotalTV = findViewById(R.id.subtotalInput);
//            taxTV = findViewById(R.id.taxinput);
//            orderET = findViewById(R.id.orderInput);
//            technitianET = findViewById(R.id.technititanInput);
//            laborET = findViewById(R.id.laborInput);
//            partET = findViewById(R.id.partInput);
//            paintET = findViewById(R.id.paintInput);


            String orderVal = orderET.getText().toString();
            String technitianVal = technitianET.getText().toString();
            String laborVal = laborET.getText().toString();
            String partVal = partET.getText().toString();
            String paintVal = paintET.getText().toString();
            String inspectionVal = inspectionET.getText().toString();

            totalTV.setText(String.valueOf(total));
            subtotalTV.setText((String.valueOf(subtotal)));
            taxTV.setText((String.valueOf(tax)));



            taxTV = findViewById(R.id.taxinput);
          //  Toast.makeText(RepairOrderActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
            Toast.makeText(RepairOrderActivity.this, partVal , Toast.LENGTH_SHORT).show();
        }
    };
}