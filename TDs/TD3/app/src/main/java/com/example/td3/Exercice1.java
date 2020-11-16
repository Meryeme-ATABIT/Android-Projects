package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Exercice1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice1);

        // récuperer l'objet button
        Button rollButton = (Button) findViewById(R.id.lancer);
        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // --------- Dé 1 --------------------
                // génerer un nombre au hazard
                int random1 = new Random().nextInt((6 - 1) + 1) + 1;
                TextView result1 = (TextView) findViewById(R.id.result1);

                // convertire le nombre entier en string pour l'afficher dans la zone de textView
                result1.setText(Integer.toString(random1));

            }
        });
    }
    }
