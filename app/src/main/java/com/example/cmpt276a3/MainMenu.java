package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        playGame();
        options();
        help();
    }

    private void playGame() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(WelcomeScreen.this);
//                startActivityForResult(intent, 1);
            }
        });
    }

    private void options() {
        Button btn = findViewById(R.id.buttonOptions);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(WelcomeScreen.this);
//                startActivityForResult(intent, 1);
            }
        });
    }

    private void help() {
        Button btn = findViewById(R.id.buttonHelp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(WelcomeScreen.this);
//                startActivityForResult(intent, 1);
            }
        });
    }



}
