package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {
    ArrayList<Model1> mList1;
    Context context1;

    public MyAdapter1(Context context1, ArrayList<Model1>mList1){
        this.mList1 = mList1;
        this.context1 = context1;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context1).inflate(R.layout.mechanics,parent,false);
        return new MyAdapter1.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         Model1 model1= mList1.get(position);
         holder.name.setText(model1.getName());
         holder.businessName.setText(model1.getBusinessName());
         holder.phone.setText(model1.getPhone());
         holder.landmark.setText(model1.getLandmark());
         holder.state.setText(model1.getState());
         holder.country.setText(model1.getCountry());

    }

    @Override
    public int getItemCount() {
        return mList1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  name,businessName,phone,landmark,state,country;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
            businessName=itemView.findViewById(R.id.business_txt);
            phone = itemView.findViewById(R.id.phone_txt);
            landmark = itemView.findViewById(R.id.landmark_txt);
            state = itemView.findViewById(R.id.state_txt);
            country=itemView.findViewById(R.id.country_txt);
        }
    }
}
