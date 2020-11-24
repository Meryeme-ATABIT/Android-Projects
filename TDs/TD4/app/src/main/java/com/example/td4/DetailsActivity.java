package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String test_name = app.getLogin();
        TextView User_name= (TextView) findViewById(R.id.test);
        User_name.setText(test_name);
    }
}