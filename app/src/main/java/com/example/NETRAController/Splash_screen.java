package com.example.NETRAController;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_screen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        VideoView videoView = findViewById(R.id.videoView);
        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        if(currentMode==Configuration.UI_MODE_NIGHT_YES){
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.netra_splashscreen_dark);
            videoView.setVideoURI(videoUri);
        }
        else{
            Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.netra_splashscreen_light);
            videoView.setVideoURI(videoUri);
        }

//        videoView.setVideoURI(videoUri);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Navigate to the next activity
                startActivity(new Intent(Splash_screen.this, Get_Started.class));
                finish();
            }
        });

        videoView.start();

//
//        Animation textani = AnimationUtils.loadAnimation(this,R.anim.text_ui);
//        Animation imageani = AnimationUtils.loadAnimation(this,R.anim.image_ui);
//        image.setVisibility(TextView.VISIBLE);
//        image.startAnimation(imageani);
//        text.setVisibility(TextView.VISIBLE);
//        text.startAnimation(textani);
//        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
//        if(currentMode==Configuration.UI_MODE_NIGHT_YES){
//            image.setImageResource(R.drawable.trfblack);
//        }
//        else{
//            image.setImageResource(R.drawable.trfwhite);
//        }
//        new Handler().postDelayed(() ->{
//            Intent splash = new Intent(Splash_screen.this,Get_Started.class);
//            startActivity(splash);
//            finish();
//        },3000);
    }
}