package com.example.pokemon.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.pokemon.R;

public class Ouverture extends AppCompatActivity {


    private LottieAnimationView start_animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouverture);

       //  Animation de l'ouverture
        start_animation = findViewById(R.id.start_animation);

        start_animation.playAnimation();

        /*new Handler().postDelayed(() -> {
            //Intent intent = new Intent(this, GenerationActivity.class);
            startActivity(intent);
        }, 10000);*/

    }
}