package com.example.doodhwalatest;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doodhwalatest.asking_option;

public class otpverification extends AppCompatActivity {

    Toolbar toolbar;

    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        submit=findViewById(R.id.submit);


        toolbar=findViewById(R.id.OTToolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("OTP Verification");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), asking_option.class);
                startActivity(intent);
            }
        });
    }
}