package com.example.doodhwalatest.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doodhwalatest.R;

import java.util.ArrayList;

public class Customer_Notification_Adapter  extends RecyclerView.Adapter<Customer_Notification_Adapter.ViewHolder> {

    ArrayList<String>message;
    Context context;

    public Customer_Notification_Adapter(Context context,ArrayList<String> message) {
        this.context=context;
        this.message = message;
    }

    @NonNull
    @Override
    public Customer_Notification_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_notification,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Customer_Notification_Adapter.ViewHolder viewHolder, int i) {
        viewHolder.text.setText(message.get(i));

    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.message);
        }
    }
}
