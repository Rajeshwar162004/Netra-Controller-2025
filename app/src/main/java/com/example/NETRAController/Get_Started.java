package com.example.NETRAController;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Get_Started extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Handler autoScroll;
    private int currentPage = 0;
    private Button getstarted;
    private static final int REQUEST_BLUETOOTH_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = {
            android.Manifest.permission.BLUETOOTH_SCAN,
            android.Manifest.permission.BLUETOOTH_CONNECT,
            android.Manifest.permission.BLUETOOTH_ADVERTISE,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        requestAllBluetoothPermissions();
        logo = findViewById(R.id.logo);

//        viewPager = findViewById(R.id.slideshow);
        getstarted = findViewById(R.id.getStartedButton);
        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if(currentMode==Configuration.UI_MODE_NIGHT_YES){
            logo.setImageResource(R.drawable.trfblack);
            getstarted.setTextColor(Color.WHITE);
        }
        else{
            logo.setImageResource(R.drawable.trfwhite);
            getstarted.setTextColor(Color.BLACK);
        }
        getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Get_Started.this,MainActivity.class));
                finish();
            }
        });

    }
    private void requestAllBluetoothPermissions() {
        List<String> permissionsToRequest = new ArrayList<>();

        for (String permission : REQUIRED_PERMISSIONS) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsToRequest.add(permission);
            }
        }

        if (!permissionsToRequest.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[0]), REQUEST_BLUETOOTH_PERMISSIONS);
        } else {
            Toast.makeText(this, "All permissions are already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_BLUETOOTH_PERMISSIONS) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;

                }
            }

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
       // autoScroll.removeCallbacksAndMessages(null);
    }
}