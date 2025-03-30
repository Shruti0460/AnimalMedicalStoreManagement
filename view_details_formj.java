package com.example.animalapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class view_details_formj extends Activity {

    RecyclerView recyclerView;
    DBHelper2 animaldb;
    ArrayList<String> animal_id, animal, medicine, vaccine, date, time;
    user_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdetails_form);

        animaldb = new DBHelper2 (this);

        animal_id = new ArrayList<>();
        animal = new ArrayList<>();
        medicine = new ArrayList<>();
        vaccine = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview1);
        adapter = new user_adapter(this, animal_id, animal, medicine, vaccine, date, time);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = animaldb.getData();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(view_details_formj.this, "No Registration Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                animal_id.add(cursor.getString(1));
                animal.add(cursor.getString(2));
                medicine.add(cursor.getString(3));
                vaccine.add(cursor.getString(4));
                date.add(cursor.getString(6));
                time.add(cursor.getString(7));
            }
        }

    }
}
