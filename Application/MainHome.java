package com.example.chemwood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_homemain );

        Button Signin = findViewById( R.id.sign1 );
        Button Signup = findViewById( R.id.sign2 );

        Signin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainHome.this,signin.class);
                startActivity( intent2 );
            }
        } );

        Signup.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainHome.this,signup.class);
                startActivity(intent1);
            }
        } );
    }

}