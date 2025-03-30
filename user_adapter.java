package com.example.animalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class user_adapter extends RecyclerView.Adapter<user_adapter.MyViewHolder>{
    private Context context;
    private ArrayList animal_id, animal, medicine, vaccine, date, time;

    public user_adapter(Context context, ArrayList animal_id, ArrayList animal, ArrayList medicine, ArrayList vaccine, ArrayList date, ArrayList time) {
        this.context = context;
        this.animal_id = animal_id;
        this.animal = animal;
        this.medicine = medicine;
        this.vaccine = vaccine;
        this.date = date;
        this.time = time;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new user_adapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.animal_id.setText(String.valueOf(animal_id.get(position)));
        holder.animal.setText(String.valueOf(animal.get(position)));
        holder.medicine.setText(String.valueOf(medicine.get(position)));
        holder.vaccine.setText(String.valueOf(vaccine.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.time.setText(String.valueOf(time.get(position)));
    }

    @Override
    public int getItemCount() { return animal_id.size();  }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView animal_id, animal, medicine, vaccine, date, time;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            animal_id = itemView.findViewById(R.id.textpet_id);
            animal = itemView.findViewById(R.id.textpet);
            medicine = itemView.findViewById(R.id.textmedicine);
            vaccine = itemView.findViewById(R.id.textvaccine);
            date = itemView.findViewById(R.id.textdate);
            time = itemView.findViewById(R.id.texttime);
        }
    }
}
