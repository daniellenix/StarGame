package com.example.cmpt276a3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class HelpScreen extends AppCompatActivity {

    public static Intent makeIntent(Context context) {
        Intent intent =  new Intent(context, HelpScreen.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        TextView HyperLink;
        Spanned Text;

        HyperLink = findViewById(R.id.links);

        Text = Html.fromHtml("Links: <br />" +
                "<a href='https://unsplash.com/photos/rCbdp8VCYhQ'>https://unsplash.com/photos/rCbdp8VCYhQ</a> <br />" +
                "<a href='https://www.flaticon.com/free-icon/star_616490?term=star&page=1&position=4'>https://www.flaticon.com/free-icon/star_616490?term=star&page=1&position=4</a> <br />" +
                "<a href='https://www.flaticon.com/free-icon/tarot_867882?term=horoscope&page=1&position=23'>https://www.flaticon.com/free-icon/tarot_867882?term=horoscope&page=1&position=23</a> <br />" +
                "<a href='https://www.flaticon.com/free-icon/sun_1137441?term=horoscope%20sun&page=1&position=5'>https://www.flaticon.com/free-icon/sun_1137441?term=horoscope%20sun&page=1&position=5</a> <br />" +
                "<a href='https://www.bitmoji.com/'>https://www.bitmoji.com/</a> <br />");


        HyperLink.setMovementMethod(LinkMovementMethod.getInstance());
        HyperLink.setText(Text);
    }
}
