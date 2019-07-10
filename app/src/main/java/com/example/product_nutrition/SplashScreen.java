package com.example.product_nutrition;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
/*
 *
 * SplashScreen Class Is Used for Animation on First Screen of the App
 * In this Class, We define Animation object to get Animation effect From transition file that we made for animation
 * All Animation Apply on Application logo
 * After some duration of time we transfer control to MainActivity Screen
 *
*/
public class SplashScreen extends AppCompatActivity {

    ImageView app_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        app_logo = findViewById(R.id.app_logo);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.transition);
        animation.setDuration(5000);
        app_logo.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        },6000);
    }
}
