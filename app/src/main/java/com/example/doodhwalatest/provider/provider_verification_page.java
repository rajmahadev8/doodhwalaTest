package com.example.doodhwalatest.provider;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doodhwalatest.R;

public class provider_verification_page extends AppCompatActivity {
  Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_verification_page);
        btn=findViewById(R.id.Continue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),provider_home.class);
                startActivity(intent);
            }
        });
    }
}