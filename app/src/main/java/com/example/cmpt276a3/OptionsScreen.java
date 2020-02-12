package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionsScreen extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, OptionsScreen.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_screen);

        boardSize();
        numberOfStars();
        eraseButton();
    }

    private void boardSize() {
        final RadioGroup radioGroup = findViewById(R.id.boardSize);
        radioGroup.clearCheck();

        // Based on which button is selected, set board size accordingly
    }

    private void numberOfStars() {
        final RadioGroup radioGroup = findViewById(R.id.numOfStars);
        radioGroup.clearCheck();

        // Based on which button is selected, set number of stars accordingly
    }

    private void eraseButton() {
        Button btn = findViewById(R.id.eraseTimesPlayed);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

}
