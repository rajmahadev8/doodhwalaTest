package com.example.doodhwalatest.provider;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doodhwalatest.Adapter.Provider_Customer_Report_Adapter;
import com.example.doodhwalatest.R;
import com.example.doodhwalatest.model.Provider_Customer_Report;

import java.util.ArrayList;

public class provider_customer_report extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Provider_Customer_Report> reports=new ArrayList<>();

    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_customer_report);

        // it for toolbar

        toolbar=findViewById(R.id.ProviderReportToolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Report");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        // handle Home icon

        home=findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),provider_home.class);
                startActivity(intent);
            }
        });

        // here handle recycleview

        recyclerView=findViewById(R.id.ProviderCustomerReportRecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Provider_Customer_Report provider_customer_report=new Provider_Customer_Report("1","Darshil Kanzariya");
        reports.add(provider_customer_report);
        reports.add(new Provider_Customer_Report("2","Mayank Patel"));
        reports.add(new Provider_Customer_Report("3","OM Mehta"));
        reports.add(new Provider_Customer_Report("4","Amit Bhutt"));

        Provider_Customer_Report_Adapter provider_customer_report_adapter=new Provider_Customer_Report_Adapter(this,reports);
        recyclerView.setAdapter(provider_customer_report_adapter);

    }

}