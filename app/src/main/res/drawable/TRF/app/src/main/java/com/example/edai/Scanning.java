package com.example.edai;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import com.google.android.gms.common.api.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;




public class Scanning extends AppCompatActivity {

    private NfcAdapter nfcAdapter;
    private ProgressBar progressBar;
    private Button btnStartScanning;
    private Button backbutton;
    private boolean isScanning = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);

        // Initialize NFC Adapter
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        // Initialize Views
        progressBar = findViewById(R.id.progressBar);
        btnStartScanning = findViewById(R.id.btnStartScanning);
        backbutton = findViewById(R.id.button);

        // Set up Start Scanning button
        btnStartScanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScanning();
            }
        });

        // Set up Back button
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the Scanning activity and return to MainActivity
                finish();
            }
        });
    }

    private void startScanning() {
        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC is not supported on this device", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show progress bar animation
        progressBar.setVisibility(View.VISIBLE);
        isScanning = true;

        // Set up NFC foreground dispatch to capture the tag
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                PendingIntent.FLAG_MUTABLE);
        IntentFilter[] intentFiltersArray = new IntentFilter[]{};
        String[][] techList = new String[][]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techList);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (isScanning && NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            // Hide the progress bar animation
            progressBar.setVisibility(View.GONE);
            isScanning = false;

            // Retrieve the NFC tag ID
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag != null) {
                byte[] tagId = tag.getId();
                StringBuilder uidBuilder = new StringBuilder();
                for (byte b : tagId) {
                    uidBuilder.append(String.format("%02X", b));
                }

                String uid = uidBuilder.toString();

                // Show UID in a Toast
                Toast.makeText(this, "NFC Tag UID: " + uid, Toast.LENGTH_LONG).show();

                // Make the API call to insert the UID
                makeApiCall(uid);
            }
        }
    }

    private void makeApiCall(String uid) {
        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Define API endpoint
        String url = "https://server.atharvajoshi0204.workers.dev/set";

        // Build JSON body
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("uid", uid);
        } catch (JSONException e) {
            e.printStackTrace();
            runOnUiThread(() -> Toast.makeText(this, "Error creating JSON: " + e.getMessage(), Toast.LENGTH_LONG).show());
            return;
        }

        // Prepare request body
        RequestBody body = RequestBody.create(
                jsonBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );

        // Create POST request
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        // Execute the request on a background thread
        new Thread(() -> {
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String responseBody = response.body() != null ? response.body().string() : "No response";
                    runOnUiThread(() -> Toast.makeText(this, "API Response: " + responseBody, Toast.LENGTH_LONG).show());
                } else {
                    runOnUiThread(() -> Toast.makeText(this, "API Error: " + response.message(), Toast.LENGTH_LONG).show());
                }
            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Network Error: " + e.getMessage(), Toast.LENGTH_LONG).show());
            }
        }).start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isScanning && nfcAdapter != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
                    PendingIntent.FLAG_MUTABLE);
            IntentFilter[] intentFiltersArray = new IntentFilter[]{};
            String[][] techList = new String[][]{};

            nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techList);
        }
    }
}
