package com.example.animalapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class mainadminpanelj extends Activity {

    ImageButton add,del,view,lgout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainadminpanel);

        add = findViewById(R.id.addcust);
        del = findViewById(R.id.delcust);
        view = findViewById(R.id.viewd);
        lgout = findViewById(R.id.lgoutbtn);

        add.setOnClickListener(view -> {
            Intent intent = new Intent( mainadminpanelj.this,addcustomerapagej.class);
            startActivity(intent);
        });

        del.setOnClickListener(view -> {
            Intent intent = new Intent( mainadminpanelj.this,deletecustpagej.class);
            startActivity(intent);

        });

        view.setOnClickListener(view -> {
            Intent intent = new Intent( mainadminpanelj.this,adminpanelj.class);
            startActivity(intent);
        });

        lgout.setOnClickListener(view -> {
            Intent intent = new Intent( mainadminpanelj.this,mainloginpagej.class);
            startActivity(intent);
            Toast.makeText(mainadminpanelj.this,"Logged out Successfully",Toast.LENGTH_SHORT).show();
        });
    }
}
