package com.example.doodhwalatest.customer;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doodhwalatest.R;

public class customer_edit_profile extends AppCompatActivity {

    Button btn;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit_profile);

        toolbar=findViewById(R.id.EditProfileToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Edit Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btn=findViewById(R.id.Update);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update();
            }

            private void Update() {
                Intent intent=new Intent(getApplicationContext(),customer_profile.class);
                startActivity(intent);
            }
        });
    }
}