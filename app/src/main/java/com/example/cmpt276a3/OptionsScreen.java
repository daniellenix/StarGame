package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.cmpt276a3.model.Options;

/**
 * Options activity saves data chosen.
 */
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

    // Populates array of radio buttons with options.
    private void boardSize() {
        final RadioGroup radioGroup = findViewById(R.id.boardSize);
        radioGroup.clearCheck();

        String[] boardSize = getResources().getStringArray(R.array.board_size);

        for (final String size : boardSize) {
            RadioButton button = new RadioButton(this);
            button.setText(size + " size");

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveBoardSize(size);
                }
            });
            radioGroup.addView(button);

            if (size.equals(getBoardSize(this))) {
                button.setChecked(true);
            }
        }
    }

    // Saves selected board size
    private void saveBoardSize(String size) {
        SharedPreferences prefs = this.getSharedPreferences("BoardPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Board size", size);
        editor.apply();

        switch (size) {
            case "4x6":
                options.setRow(4);
                options.setColumn(6);
                break;
            case "5x10":
                options.setRow(5);
                options.setColumn(10);
                break;
            case "6x15":
                options.setRow(6);
                options.setColumn(15);
                break;
        }
    }

    // Takes the default value for the board size
    public static String getBoardSize(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("BoardPrefs", MODE_PRIVATE);
        String defaultValue = context.getResources().getString(R.string.default_board_size);

        return prefs.getString("Board size", defaultValue);
    }

    // Populates array of radio buttons with star options
    private void numberOfStars() {

        RadioGroup radioGroup = findViewById(R.id.numOfStars);
        radioGroup.clearCheck();

        int[] numStars = getResources().getIntArray(R.array.num_stars);

        for (final int numStar : numStars) {
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

    // Saves number of stars chosen
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

    // Sets default number of stars
    static public int getNumberOfStars(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("StarPrefs", MODE_PRIVATE);
        int defaultValue = context.getResources().getInteger(R.integer.default_num_stars);
        return prefs.getInt("Number of Stars", defaultValue);
    }

}
