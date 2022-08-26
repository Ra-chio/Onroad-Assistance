package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<Model>mList;
    Context context;

    public MyAdapter(Context context, ArrayList<Model>mList){
        this.mList = mList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.users,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      Model model = mList.get(position);
        holder.name.setText(model.getName());
        holder.phone.setText(model.getPhone());
        holder.problem.setText(model.getProblem());
        holder.landmark.setText(model.getLandmark());
        holder.location.setText(model.getLocation());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,phone,problem,landmark,location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
           phone = itemView.findViewById(R.id.phone_txt);
           problem = itemView.findViewById(R.id.problem_txt);
            landmark = itemView.findViewById(R.id.landmark_txt);
           location= itemView.findViewById(R.id.location_txt);

        }
    }
}
