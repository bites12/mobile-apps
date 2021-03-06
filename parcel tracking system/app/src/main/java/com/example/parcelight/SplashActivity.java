package com.example.parcelight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private long delay = 2500;
    private TimerTask task = new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(SplashActivity.this, MainPage.class));
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timer timer =new Timer();
        timer.schedule(task,delay);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
    }
}
