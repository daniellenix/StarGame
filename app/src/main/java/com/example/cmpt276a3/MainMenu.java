package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cmpt276a3.model.Options;

/**
 * Provides buttons to play game, click options or help.
 */
public class MainMenu extends AppCompatActivity {

    private Options options = Options.getInstance();

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, MainMenu.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        playGame();
        options();
        help();

        // Default options, if nothing is selected
        options.setRow(4);
        options.setColumn(6);
        options.setNumberOfStars(6);
    }

    private void playGame() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = GameScreen.makeIntent(MainMenu.this);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void options() {
        Button btn = findViewById(R.id.buttonOptions);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = OptionsScreen.makeIntent(MainMenu.this);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void help() {
        Button btn = findViewById(R.id.buttonHelp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = HelpScreen.makeIntent(MainMenu.this);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
