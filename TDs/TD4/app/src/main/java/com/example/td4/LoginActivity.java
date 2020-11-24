package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        Button Sign_in = (Button) findViewById(R.id.login);

        Sign_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText email = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);
                EditText User_name = (EditText) findViewById(R.id.name);

                if(email != null && password != null && User_name != null){
                    Intent intent = new Intent(v.getContext(), NewsActivity.class);
                    NewsListApplication app = (NewsListApplication) getApplicationContext();
                    app.setLogin(User_name.getText().toString());
                    intent.putExtra("login", User_name.getText().toString());
                    startActivity(intent);
                }else{
                    Toast.makeText(v.getContext(), "empty email or password", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}