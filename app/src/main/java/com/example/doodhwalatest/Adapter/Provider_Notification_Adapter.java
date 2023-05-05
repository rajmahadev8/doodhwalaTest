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

public class Provider_Notification_Adapter  extends RecyclerView.Adapter<Provider_Notification_Adapter.ViewHolder>{
    @NonNull
    Context context;
    ArrayList<String> message=new ArrayList<>();

    public Provider_Notification_Adapter(@NonNull Context context, ArrayList<String> message) {
        this.context = context;
        this.message = message;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_provider_notification,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Provider_Notification_Adapter.ViewHolder viewHolder, int i) {
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
