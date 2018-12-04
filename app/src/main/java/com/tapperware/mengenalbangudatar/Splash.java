package com.tapperware.mengenalbangudatar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    private long ms = 0;
    private long splashTime = 3000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread myThread = new Thread(){
            public void run(){
                try {
                    while(splashActive&&ms < splashTime){
                        if(!paused){
                            ms = ms + 10;
                            sleep(10);
                        }
                    }
                }catch (Exception e){
                }finally {
                    Intent pindah = new Intent(Splash.this, MainActivity.class);
                    startActivity(pindah);
                    finish();
                }
            }
        };
        myThread.start();
    }
}
