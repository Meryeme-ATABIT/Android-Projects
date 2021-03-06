package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Exercice3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);

        // récuperer l'objet button
        Button rollButton = (Button) findViewById(R.id.lancer3);
        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText edit_text = findViewById(R.id.nombre_face);
                int nbfaces = Integer.parseInt(String.valueOf(edit_text.getText()));

                // --------- Dé 1 --------------------
                // génerer un nombre au hazard
                int random1 = new Random().nextInt((nbfaces - 1) + 1) + 1;
                TextView result4 = (TextView) findViewById(R.id.result4);

                // convertire le nombre entier en string pour l'afficher dans la zone de textView
                result4.setText(Integer.toString(random1));

            }
        });
    }
    }
