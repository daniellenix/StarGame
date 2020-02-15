package com.example.cmpt276a3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmpt276a3.model.CellManager;
import com.example.cmpt276a3.model.Options;

public class GameScreen extends AppCompatActivity {


    private CellManager cellManager = CellManager.getInstance();
    private Options options = Options.getInstance();

    Button buttons[][] = new Button[options.getRow()][options.getColumn()];


    private int FOUND = 0;
    private int SCANS_USED = 0;
    private int USER_PLAYED = 0;
    private int ROWS;
    private int COLS;
    private int STARS;

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, GameScreen.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        populateButtons();
        refreshScreen();
    }

    private void refreshScreen() {
        TextView starsFound = findViewById(R.id.foundStars);
        int numStars = OptionsScreen.getNumberOfStars(this);
        starsFound.setText("Found 0 of " + numStars);

        // TODO: set scans used and times played
        TextView numOfScans = findViewById(R.id.scansUsed);
//        int numStars = OptionsScreen.getNumberOfStars(this);
//        starsFound.setText("Found 0 of " + numStars);

        TextView timesPlayed = findViewById(R.id.timesPlayed);
//        int numStars = OptionsScreen.getNumberOfStars(this);
//        starsFound.setText("Found 0 of " + numStars);
    }

    private void populateButtons() {
        TableLayout table = findViewById(R.id.tableForButtons);

        for (int row = 0; row < options.getRow(); row++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);

            for (int col = 0; col < options.getColumn(); col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;

                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                // text on buttons before pressed
                button.setText("" + col + "," + row);

                // Make text not clip on small buttons
                button.setPadding(0, 0, 0, 0);

                button.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v) {
                        gridButtonClicked(FINAL_COL, FINAL_ROW);
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void gridButtonClicked(int col, int row) {
        Toast.makeText(this, "Button clicked: " + col + "," + row,
                Toast.LENGTH_SHORT).show();
        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();

        int newWidth = button.getWidth();
        int newHeight = button.getHeight();

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));

        // text on buttons once pressed
        button.setText("" + col);

    }

    private void lockButtonSizes() {
        for (int row = 0; row < options.getRow(); row++) {
            for (int col = 0; col < options.getColumn(); col++) {
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void getGameLogic(){
        ROWS = options.getRow();
        COLS = options.getColumn();
        STARS = options.getNumberOfStars();

        cellManager = CellManager.getInstance();
        cellManager.updateCells();
        buttons = new Button[options.getRow()][options.getColumn()];
    }

    private void callAlertMessage(){
        if (FOUND == STARS){
            FragmentManager manager = getSupportFragmentManager();
            AlertScreen dialog = new AlertScreen();
            //dialog.show(manager,getString(R.string.));
        }
    }

    private void saveHighscore(){
        if(USER_PLAYED == 1){
            SharedPreferences prefs = this.getSharedPreferences(getString(R.string.),MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            String rowSize = Integer.toString(ROWS);
            String colSize = Integer.toString(COLS);
            String numberOfStars = Integer.toString(STARS);

            String dimensions = rowSize + "x" + colSize + "@" + numberOfStars;

            editor.putInt(dimensions,SCANS_USED);
            editor.apply();
        }
    }
}
