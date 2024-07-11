package com.example.xo_game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        makeHandelar();
    }


    private void makeHandelar(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splach();
            }
        },800);
    }
    private void splach() {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
        finish();
    }


}
