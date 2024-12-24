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

public class MakeTeam extends AppCompatActivity {

    private Button back,submit;
    private EditText Vehicle_id,vehicle,bins,operator,Driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_make_team);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        back=findViewById(R.id.back_button);
        submit=findViewById(R.id.submit_button);
        Vehicle_id=findViewById(R.id.editText_vehicle_id);
        vehicle=findViewById(R.id.editText_vehicle);
        bins=findViewById(R.id.editText_bin_id);
        operator=findViewById(R.id.editText_operator);
        Driver=findViewById(R.id.editText_driver);

        int binId=Integer.parseInt(bins.getText().toString());
        String operatorname=operator.getText().toString();
        String drivername=Driver.getText().toString();
        String vehiclenum=vehicle.getText().toString();
        int vehicleID=Integer.parseInt(Vehicle_id.getText().toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backgo=new Intent(MakeTeam.this,MainActivity.class);
                startActivity(backgo);
            }
        });
    }
}