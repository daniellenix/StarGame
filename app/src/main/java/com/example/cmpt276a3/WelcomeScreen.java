package com.example.cmpt276a3;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class WelcomeScreen extends AppCompatActivity{
    Animation rotateAnimation;
    Animation bounceAnimation;
    Animation fadeInAnimation;
    Animation blinkAnimation;

    Button btn;
    ImageView star_circle;
    TextView bounceTextView;
    TextView fadeInTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

        star_circle= (ImageView)findViewById(R.id.star_circle);
        rotateAnimation();

        bounceTextView = (TextView)findViewById(R.id.welcome_Title);
        bounceAnimation();

        fadeInTextView = (TextView)findViewById(R.id.author_Names);
        fadeInAnimation();

        btn = (Button)findViewById(R.id.buttonSkip);
        blinkAnimation();
        //Animation bounce = AnimationUtils.loadAnimation(this,R.anim.bounce);
        //Animation fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        //Animation blink = AnimationUtils.loadAnimation(this, R.anim.blink);
        //Button btn = findViewById(R.id.buttonSkip);

        skip();
    }

    private void skip() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(WelcomeScreen.this);
//                startActivityForResult(intent, 1);
            }
        });
    }

    private void rotateAnimation(){
        rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        star_circle.startAnimation(rotateAnimation);

    }

    private void bounceAnimation(){
        bounceAnimation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        bounceTextView.startAnimation(bounceAnimation);
    }

    private void fadeInAnimation(){
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeInTextView.startAnimation(fadeInAnimation);
    }

    private void blinkAnimation(){
        blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink);
        btn.startAnimation(blinkAnimation);
    }

}

