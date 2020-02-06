package com.example.cmpt276a3;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity{

    Animation rotateAnimation;
    TextView text_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        text_animation = findViewById(R.id.welcome_Title);

        //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        skip();

    }

    private void skip() {
        Button btn = findViewById(R.id.buttonSkip);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = ThirdActivity.makeIntent(MainActivity.this);
//                startActivityForResult(intent, 1);
            }
        });
    }

    private void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        text_animation.startAnimation(animation);
    }

}
