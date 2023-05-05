package com.example.doodhwalatest.provider;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doodhwalatest.Adapter.Provider_Notification_Adapter;
import com.example.doodhwalatest.R;

import java.util.ArrayList;

public class provider_notification extends AppCompatActivity {

    ArrayList<String> message=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_notification);

        recyclerView=findViewById(R.id.RecycleViewOfpNotification);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        message.add("Soory today i am not available");
        message.add("hellow I am not taking milk today");

        Provider_Notification_Adapter provider_notification_adapter=new Provider_Notification_Adapter(this,message);
        recyclerView.setAdapter(provider_notification_adapter);






    }
}