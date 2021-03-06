package com.example.swords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Main extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);


        final long period = 200;
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (i < 100) {
                    progressBar.setProgress(i);
                    i+=2;
                } else {
                    timer.cancel();
                    Intent intent = new Intent(Main.this, menu.class);
                    startActivity(intent);
                    finish();
                }
            }
            }, 0, period);
        }

}
