package com.example.doodhwalatest.provider;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.doodhwalatest.R;

public class provider_sales extends AppCompatActivity {


Toolbar toolbar;
ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_sales);

        // it is for toolbar

        toolbar=findViewById(R.id.ProviderSales);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Sales");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Handle home icon

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),provider_home.class);
                startActivity(intent);
            }
        });

        // it is for dropdown

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mothes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // here we have set repsonse

       /* spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String moth = (String) adapterView.getItemAtPosition(i);
                Toast.makeText(provider_sales.this, "Selected item: " + moth, Toast.LENGTH_SHORT).show();
            }
        });*/





    }

    }



