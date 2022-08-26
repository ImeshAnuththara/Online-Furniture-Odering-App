package com.example.chemwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
               Intent Splash =new Intent(MainActivity.this, MainHome.class);
               startActivity(Splash);
               finish();
            }
        } ,SPLASH_TIME_OUT);


    }

}