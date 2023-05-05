package com.example.doodhwalatest.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doodhwalatest.R;
import com.example.doodhwalatest.model.Provider_Customer_Report;

import java.util.ArrayList;

public class Provider_Customer_Report_Adapter extends  RecyclerView.Adapter<Provider_Customer_Report_Adapter.ViewHolder> {
    Context context;
    ArrayList<Provider_Customer_Report> reports=new ArrayList<>();

    public Provider_Customer_Report_Adapter(Context context, ArrayList<Provider_Customer_Report> reports) {
        this.context = context;
        this.reports = reports;
    }

    @NonNull
    @Override
    public Provider_Customer_Report_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_provider_customer_report,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Provider_Customer_Report_Adapter.ViewHolder viewHolder, int i) {
        viewHolder.no.setText(reports.get(i).getNo());
        viewHolder.name.setText(reports.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView no,name;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            no=itemView.findViewById(R.id.Number);
            name=itemView.findViewById(R.id.Name);
            btn=itemView.findViewById(R.id.View);

        }
    }
}
