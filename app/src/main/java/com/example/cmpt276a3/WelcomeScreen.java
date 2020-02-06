package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        skip();
    }

    private void skip() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(MainActivity.this);
//                startActivityForResult(intent, 1);
            }
        });
    }

}
