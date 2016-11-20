package com.example.robertyost.hackohio2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    public void onSignUpBtnClick(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void onLoginBtnClick(View view) {
        //@Katrina -- change the second argument to what page you want to go to
        Intent tempDeepBreathingIntent = new Intent(this, DeepBreathing1.class);
        startActivity(tempDeepBreathingIntent);
    }
}
