package com.example.NETRAController;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.example.NETRAController.R;

public class loading_dialog {
    static Activity activity;
    private static AlertDialog dialog;

    loading_dialog(Activity myActivity) {
        activity = myActivity;
    }

    public static void startloading() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false); // Prevent dismissal by touch or back button

        dialog = builder.create();

        // Set transparent background
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        dialog.show();
    }

    void startloding() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false); // Prevent dismissal by touch or back button

        dialog = builder.create();

        // Set transparent background
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        dialog.show();
    }

    static void dismissloading() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
