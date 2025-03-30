package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
public class userpanelj extends Activity {

    ImageButton btn8, btn9, btn10, log_out;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpanel);

        btn8 = findViewById(R.id.formreg);
        btn9 = findViewById(R.id.formviewd);
        btn10 = findViewById(R.id.formaddreminder);
        log_out = findViewById(R.id.userlogoutbtn);

        log_out.setOnClickListener(view -> {
            Intent intent = new Intent( userpanelj.this,mainloginpagej.class);
            startActivity(intent);
            Toast.makeText(userpanelj.this,"Logged out Successfully",Toast.LENGTH_SHORT).show();
        });

        btn8.setOnClickListener(view -> {
            Intent intent = new Intent( userpanelj.this,registration_formj.class);
            startActivity(intent);
        });

        btn9.setOnClickListener(view -> {
            Intent intent = new Intent( userpanelj.this,view_details_formj.class);
            startActivity(intent);
        });

        btn10.setOnClickListener(view -> {
            Intent intent = new Intent( userpanelj.this,add_reminder_formj.class);
            startActivity(intent);
        });
    }
}
