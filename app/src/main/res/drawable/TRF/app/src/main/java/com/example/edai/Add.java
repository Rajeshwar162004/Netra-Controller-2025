package com.example.edai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Add extends AppCompatActivity {

    private Button back,submit;
    private EditText fuel,Start_km,End_Km,amount,vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submit=findViewById(R.id.sub);
        back=findViewById(R.id.back1);
        fuel=findViewById(R.id.fuel);
        Start_km=findViewById(R.id.editTextText);
        End_Km=findViewById(R.id.editTextText2);
        amount=findViewById(R.id.amount);
        vehicle=findViewById(R.id.fuel2);

        int Fuel_consumed=Integer.parseInt(fuel.getText().toString());
        int Start_kmval=Integer.parseInt(Start_km.getText().toString());
        int End_Kmval=Integer.parseInt(End_Km.getText().toString());
        int Amount=Integer.parseInt(amount.getText().toString());
        int vehicleID=Integer.parseInt(vehicle.getText().toString());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add.this, MainActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}