package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class HelpScreen extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, HelpScreen.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);
    }
}
