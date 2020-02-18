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
import android.os.FileObserver;
import android.os.Message;
import android.telephony.SmsManager;
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

    Button buttons[][];

    private int foundStars;
    private int scansUsed;
    private int userPlayed;

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, GameScreen.class);
        return intent;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        buttons = new Button[options.getRow()][options.getColumn()];
        populateButtons();
        callAlertMessage();
    }

    private void refreshScreen() {
        TextView starsFound = findViewById(R.id.foundStars);
        int numStars = OptionsScreen.getNumberOfStars(this);
        starsFound.setText("Found " + foundStars + " of " + numStars);

        TextView numOfScans = findViewById(R.id.scansUsed);
        numOfScans.setText("# of scans used: " + scansUsed);

        TextView timesPlayed = findViewById(R.id.timesPlayed);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void populateButtons() {
        TableLayout table = findViewById(R.id.tableForButtons);
        cellManager.generateStarsRandomly();

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

                // adds buttons to each row and col
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));


                // Make text not clip on small buttons
                button.setPadding(0, 0, 0, 0);

                button.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v) {

                        // if cell has star
                        if(cellManager.hasStarNotClicked(FINAL_ROW, FINAL_COL)) {
                            showStar(FINAL_ROW, FINAL_COL);
                            foundStars++;
                            cellManager.markStarClicked(FINAL_ROW, FINAL_COL);
                        }

                        // Performs a scan if no mine is present
                        else if(cellManager.noStarNotClicked(FINAL_ROW, FINAL_COL)) {
                            cellManager.markNoStarClicked(FINAL_ROW, FINAL_COL);
                            scan(FINAL_ROW, FINAL_COL);
                            scansUsed++;
                        }

                        // Performs a scan if mine has already been revealed
                        else if(cellManager.hasStarAndClicked(FINAL_ROW, FINAL_COL)) {
                            cellManager.markStarClicked(FINAL_ROW, FINAL_COL);
                            scan(FINAL_ROW, FINAL_COL);
                            scansUsed++;
                        }

                        refreshScreen();
//                        callAlertMessage();
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void showStar(int row, int col) {

        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();

        int newWidth = button.getWidth();
        int newHeight = button.getHeight();

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void scan(int row, int col) {
        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();
        int scan = cellManager.scanRowAndCol(row, col);

        // text on buttons once pressed
        button.setText("" + scan);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void scanMinusOne(int row, int col) {
        Button button = buttons[row][col];

        // Lock Button Sizes:
        lockButtonSizes();
        int scan = cellManager.scanRowAndCol(row, col) - 1;

        // text on buttons once pressed
        button.setText("" + scan);
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

    private void callAlertMessage(){
        if (foundStars == options.getNumberOfStars()){
            FragmentManager manager = getSupportFragmentManager();
            AlertScreen dialog = new AlertScreen();
            dialog.show(manager, "Message Dialog");
            Log.i("TAG", "Just showed the dialog");
        }
    }

    //figured out how to do the shared preferences
    private void saveScore(){
        if(userPlayed == 1){

            //SharedPreferences prefs = this.getSharedPreferences(getString(R.string.),MODE_PRIVATE);
            //SharedPreferences.Editor editor = prefs.edit();

            String rowSize = Integer.toString(options.getRow());
            String colSize = Integer.toString(options.getColumn());
            String numberOfStars = Integer.toString(options.getNumberOfStars());

            String dimensions = rowSize + colSize + numberOfStars;

            //editor.putInt(dimensions,scans_Used);
            //editor.apply();
        }
    }
}
