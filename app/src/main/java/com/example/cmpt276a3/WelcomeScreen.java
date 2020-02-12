package com.example.cmpt276a3;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity{
    TextView text_animation;
    TextView names_animation;
    Button btn = findViewById(R.id.buttonSkip);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        //overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        skip();
        toFade(text_animation);
        toScale(names_animation);
        tapToSlideOut(btn);

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

    private void toFade(View view){
        text_animation = findViewById(R.id.welcome_Title);
        Animation fade_in_animation = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        text_animation.startAnimation(fade_in_animation);
    }

    private void toScale(View view){
        names_animation = findViewById(R.id.author_Names);
        Animation scale_animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        names_animation.startAnimation(scale_animation);
    }

    private void tapToSlideOut(View view){
        Button btn = findViewById(R.id.buttonSkip);
        Animation slide_animation = AnimationUtils.loadAnimation(this,R.anim.slide_out);
        btn.startAnimation(slide_animation);
    }

}

