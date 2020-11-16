package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Exercice2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice2);

        // récuperer l'objet button
        Button rollButton = (Button) findViewById(R.id.lancer2);
        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // --------- Dé 1 --------------------
                // génerer un nombre au hazard
                int random1 = new Random().nextInt((5) + 1) + 1;
                TextView result1 = (TextView) findViewById(R.id.result2);

                // convertire le nombre entier en string pour l'afficher dans la zone de textView
                result1.setText(Integer.toString(random1));


                // ---------- Dé 2 -------------------

                // génerer un nombre au hazard
                int random2 = new Random().nextInt((5)+1) +1;
                TextView result2 = (TextView) findViewById(R.id.result3);

                // convertire le nombre entier en string pour l'afficher dans la zone de textView
                result2.setText(Integer.toString(random2));
            }
        });
    }
    }
