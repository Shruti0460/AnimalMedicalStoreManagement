package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class signuppagej extends Activity {
    ImageButton btn6;
    EditText username,password,repassword;
    DBHelper MyDb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.passtwo);
        btn6 = findViewById(R.id.sgnsubmitbtn);

        MyDb = new DBHelper (this);

        btn6.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals(""))
            {
                Toast.makeText(signuppagej.this,"Fill All the Fields.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(pass.equals(repass))
                {
                    Boolean result = MyDb.checkusername(user);
                    if(!result)
                    {
                        Boolean regresult = MyDb.insertData(user,pass);

                        if(regresult){
                            Toast.makeText(signuppagej.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),userloginpagej.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(signuppagej.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(signuppagej.this,"User Already Exists\n please sign in",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(signuppagej.this,"Password not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
