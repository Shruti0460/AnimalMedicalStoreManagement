package com.example.animalapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adminpanelj extends Activity {

    RecyclerView recyclerView;
    DBHelper2 animaldb;
    ArrayList<String> name, animal_id, animal, medicine, vaccine, reason, date, time, number, mail;
    list_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminpanel);

        animaldb = new DBHelper2 (this);

        name = new ArrayList<>();
        animal_id = new ArrayList<>();
        animal = new ArrayList<>();
        medicine = new ArrayList<>();
        vaccine = new ArrayList<>();
        reason = new ArrayList<>();
        date = new ArrayList<>();
        time = new ArrayList<>();
        number = new ArrayList<>();
        mail = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new list_adapter(this,name, animal_id, animal, medicine, vaccine, reason, date, time, number);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = animaldb.getData();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(adminpanelj.this, "No Registration Exists", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                animal_id.add(cursor.getString(1));
                animal.add(cursor.getString(2));
                medicine.add(cursor.getString(3));
                vaccine.add(cursor.getString(4));
                reason.add(cursor.getString(5));
                date.add(cursor.getString(6));
                time.add(cursor.getString(7));
                number.add(cursor.getString(8));
            }
        }
    }
}
