package com.example.animalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btn1 = findViewById(R.id.nxtbtn1);
        btn1.setOnClickListener(view -> {
            Intent intent = new Intent( MainActivity.this,mainloginpagej.class);
            startActivity(intent);
        });
    }
}