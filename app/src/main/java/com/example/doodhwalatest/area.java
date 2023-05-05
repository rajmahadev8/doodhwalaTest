package com.example.doodhwalatest;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class area extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area);
        Spinner spin=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.qty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(adapter);
    }


    public void handleMilkTypeBtn(View v) {
        Button btn = (Button) findViewById(v.getId());
        String text = btn.getText().toString();
        LinearLayout qtyLayout = (LinearLayout) findViewById(R.id.qtyLayout);
        LinearLayout btnsLayout = (LinearLayout) findViewById(R.id.btnsLayout);
        qtyLayout.setVisibility(View.VISIBLE);
        btnsLayout.setVisibility(View.GONE);
    }

    public void handleDoneBtn(View view) {
        LinearLayout qtyLayout = (LinearLayout) findViewById(R.id.qtyLayout);
        LinearLayout btnsLayout = (LinearLayout) findViewById(R.id.btnsLayout);
        qtyLayout.setVisibility(View.GONE);
        btnsLayout.setVisibility(View.VISIBLE);
        Toast.makeText(this, "અપાઇ દિધુ", Toast.LENGTH_SHORT).show();    }
}
