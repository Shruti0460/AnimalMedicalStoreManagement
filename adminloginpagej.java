package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class adminloginpagej extends Activity {
    ImageButton btn7;
    EditText adminname,adminpassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminloginpage);

        adminname = findViewById(R.id.adminid);
        adminpassword = findViewById(R.id.adminpassword);
        btn7= findViewById(R.id.adminloginbtn);

        btn7.setOnClickListener(view -> {
            String aname = adminname.getText().toString();
            String apass = adminpassword.getText().toString();

            if(aname.equals("")||apass.equals(""))
            {
                Toast.makeText(adminloginpagej.this,"Fill All the Fields.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(aname.equals("admin") && apass.equals("123456")){
                    Toast.makeText(adminloginpagej.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(adminloginpagej.this,mainadminpanelj.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(adminloginpagej.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
