package com.example.cmpt276a3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cmpt276a3.model.CellManager;

import org.w3c.dom.Text;

public class WelcomeScreen extends AppCompatActivity{

    ImageView star_circle;
    TextView bounceTextView;
    TextView fadeInTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        rotateAnimation();
        bounceAnimation();
        fadeInAnimation();
        blinkAnimation();
        skip();
    }

    private void skip() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainMenu.makeIntent(WelcomeScreen.this);
                startActivityForResult(intent, 1);
            }
        });
    }

    private void rotateAnimation(){
        star_circle = findViewById(R.id.star_circle);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        star_circle.startAnimation(rotateAnimation);

    }

    private void bounceAnimation(){
        bounceTextView = findViewById(R.id.welcome_Title);
        Animation bounceAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        bounceTextView.startAnimation(bounceAnimation);
    }

    private void fadeInAnimation(){
        fadeInTextView = findViewById(R.id.author_Names);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeInTextView.startAnimation(fadeInAnimation);
    }

    private void blinkAnimation(){
        Button btn = findViewById(R.id.buttonSkip);
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        btn.startAnimation(blinkAnimation);
    }
}

