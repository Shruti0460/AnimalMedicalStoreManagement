package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class userloginpagej extends Activity {
    ImageButton btn4, btn5;
    EditText username,password;
    DBHelper MyDb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userloginpage);

        username = findViewById(R.id.usernameL);
        password = findViewById(R.id.passwordL);
        btn4 = findViewById(R.id.userlogin);
        MyDb = new DBHelper(this);

        btn4.setOnClickListener(view -> {
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.equals("")||pass.equals(""))
            {
                Toast.makeText(userloginpagej.this,"Fill All the Fields.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Boolean lresult = MyDb.checkusernamePassword(name,pass);

                if(lresult){
                    Toast.makeText(userloginpagej.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),userpanelj.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(userloginpagej.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn5 = findViewById(R.id.usersignup);
        btn5.setOnClickListener(view -> {
            Intent intent = new Intent( userloginpagej.this,signuppagej.class);
            startActivity(intent);
        });
    }
}
