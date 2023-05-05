package com.example.doodhwalatest.customer;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doodhwalatest.MainActivity;
import com.example.doodhwalatest.R;

public class customer_profile extends AppCompatActivity {
    Button logout;
    ImageView edit_profile;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        toolbar=findViewById(R.id.ProfileToolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Profile");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        logout=findViewById(R.id.Logout);
        edit_profile=findViewById(R.id.EditeProfile);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
            private void logout() {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_profile();
            }

            private void edit_profile() {
                Intent intent=new Intent(getApplicationContext(),customer_edit_profile.class);
                startActivity(intent);
            }
        });




    }
}