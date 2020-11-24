package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());
        Intent intent = getIntent();
        Button About = (Button) findViewById(R.id.about);
        Button Details = (Button) findViewById(R.id.details);
        String login;
        if (intent.hasExtra("login")){
           login = intent.getStringExtra("login");
        }
        About.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = "https://news.google.com/";
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent1);

            }
        }
        );
        Details.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), DetailsActivity.class);
                startActivity(intent2);

            }
        }
        );
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}