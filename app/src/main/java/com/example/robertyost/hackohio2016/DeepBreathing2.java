package com.example.robertyost.hackohio2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class DeepBreathing2 extends AppCompatActivity {

    public void onClick(View v) {
        startActivity(new Intent(DeepBreathing2.this, DeepBreathing3.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_breathing2);
        final View view = findViewById(R.id.circle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        final Animation animf = AnimationUtils.loadLayoutAnimation(this, R.anim.scale1).getAnimation();

        Button button = (Button) findViewById(R.id.startExerciseBtn);
        button.setOnClickListener(new View.OnClickListener(){
            int i = 0;
            boolean wantOff = false;
            public void onClick(View v) {
                while (i == 0) {
                    view.startAnimation(anim);
                    view.startAnimation(animf);
                    if (wantOff) {

                    }
                    }

                }
            }
        );
    }
}
