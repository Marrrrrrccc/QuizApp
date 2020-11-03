package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);//
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, 3000);
    }
}
