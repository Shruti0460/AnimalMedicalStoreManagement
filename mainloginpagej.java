package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class mainloginpagej extends Activity {

    ImageButton btn2,btn3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainloginpage);

        btn2 = findViewById(R.id.adminloginbtn1);
        btn2.setOnClickListener(view -> {
            Intent intent = new Intent( mainloginpagej.this,adminloginpagej.class);
            startActivity(intent);
        });

        btn3 = findViewById(R.id.userloginbtn1);
        btn3.setOnClickListener(view -> {
            Intent intent = new Intent(mainloginpagej.this,userloginpagej.class);
            startActivity(intent);
        });
    }
}
