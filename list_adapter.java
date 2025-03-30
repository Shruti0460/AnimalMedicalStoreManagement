package com.example.animalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list_adapter extends RecyclerView.Adapter<list_adapter.MyViewHolder> {

    private Context context;
    private ArrayList name, animal_id, animal, medicine, vaccine, reason, date, time, number;

    public list_adapter(Context context, ArrayList name, ArrayList animal_id, ArrayList animal, ArrayList medicine, ArrayList vaccine, ArrayList reason, ArrayList date, ArrayList time, ArrayList number) {
        this.context = context;
        this.name = name;
        this.animal_id = animal_id;
        this.animal = animal;
        this.medicine = medicine;
        this.vaccine = vaccine;
        this.reason = reason;
        this.date = date;
        this.time = time;
        this.number = number;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.animal_id.setText(String.valueOf(animal_id.get(position)));
        holder.animal.setText(String.valueOf(animal.get(position)));
        holder.medicine.setText(String.valueOf(medicine.get(position)));
        holder.vaccine.setText(String.valueOf(vaccine.get(position)));
        holder.reason.setText(String.valueOf(reason.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.time.setText(String.valueOf(time.get(position)));
        holder.number.setText(String.valueOf(number.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, animal_id, animal, medicine, vaccine, reason, date, time, number;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textname);
            animal_id = itemView.findViewById(R.id.textpet_id);
            animal = itemView.findViewById(R.id.textpet);
            medicine = itemView.findViewById(R.id.textmedicine);
            vaccine = itemView.findViewById(R.id.textvaccine);
            reason = itemView.findViewById(R.id.textreason);
            date = itemView.findViewById(R.id.textdate);
            time = itemView.findViewById(R.id.texttime);
            number = itemView.findViewById(R.id.textnum);
        }
    }
}
