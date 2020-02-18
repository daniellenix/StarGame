package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cmpt276a3.model.CellManager;
import com.example.cmpt276a3.model.Options;

public class OptionsScreen extends AppCompatActivity {

    private Options options = Options.getInstance();

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
    }

    private void boardSize() {
        final RadioGroup radioGroup = findViewById(R.id.boardSize);
        radioGroup.clearCheck();

        String[] boardSize = getResources().getStringArray(R.array.board_size);

        for (int i = 0; i < boardSize.length; i++) {
            final String size = boardSize[i];

            RadioButton button = new RadioButton(this);
            button.setText(size + " size");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveBoardSize(size);
                }
            });
            radioGroup.addView(button);

            if (size.equals(getBoardSize(this))){
                button.setChecked(true);
            }
        }
    }

    private void saveBoardSize(String size) {
        SharedPreferences prefs = this.getSharedPreferences("BoardPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Board size", size);
        editor.apply();

        if(size.equals("4x6")) {
            options.setRow(4);
            options.setColumn(6);
        } else if(size.equals("5x10")) {
            options.setRow(5);
            options.setColumn(10);
        } else if(size.equals("6x15")) {
            options.setRow(6);
            options.setColumn(15);
        }
    }

    public static String getBoardSize(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("BoardPrefs", MODE_PRIVATE);
        String defaultValue = context.getResources().getString(R.string.default_board_size);

        return prefs.getString("Board size", defaultValue);
    }

    private void numberOfStars() {

        RadioGroup radioGroup = findViewById(R.id.numOfStars);
        radioGroup.clearCheck();

        int[] numStars = getResources().getIntArray(R.array.num_stars);

        for (int i = 0; i < numStars.length; i++) {
            final int numStar = numStars[i];

            RadioButton button = new RadioButton(this);
            button.setText(numStar + " stars");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveNumberOfStars(numStar);
                }
            });
            radioGroup.addView(button);

            if (numStar == getNumberOfStars(this)) {
                button.setChecked(true);
            }
        }
    }

    private void saveNumberOfStars(int numStar) {
        SharedPreferences prefs = this.getSharedPreferences("StarPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Number of Stars", numStar);
        editor.apply();

        if(numStar == 6) {
            options.setNumberOfStars(6);
        } else if(numStar == 10) {
            options.setNumberOfStars(10);
        } else if(numStar == 15) {
            options.setNumberOfStars(15);
        } else if(numStar == 20) {
            options.setNumberOfStars(20);
        }
    }

    static public int getNumberOfStars(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("StarPrefs", MODE_PRIVATE);
        int defaultValue = context.getResources().getInteger(R.integer.default_num_stars);
        return prefs.getInt("Number of Stars", defaultValue);
    }

}
