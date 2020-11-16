package com.example.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Exo1 = (Button) findViewById(R.id.exo1);
        Button Exo2 = (Button) findViewById(R.id.exo2);
        Button Exo3 = (Button) findViewById(R.id.exo3);

        Exo1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Exercice1.class);
                startActivity(intent);
            }
        });

        Exo2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Exercice2.class);
                startActivity(intent);
            }
        });

        Exo3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), Exercice3.class);
                startActivity(intent);
            }
        });
    }
}