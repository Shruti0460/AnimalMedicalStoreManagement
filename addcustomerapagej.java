package com.example.animalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class addcustomerapagej extends Activity {

    ImageButton reg;
    EditText user,pas,repas;
    DBHelper MyDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcustomerpage);

        user = findViewById(R.id.uname);
        pas = findViewById(R.id.upass);
        repas = findViewById(R.id.urepass);
        reg = findViewById(R.id.regbtn);

        MyDb = new DBHelper (this);

        reg.setOnClickListener(view -> {
            String usern = user.getText().toString();
            String pass = pas.getText().toString();
            String repass = repas.getText().toString();

            if(usern.equals("")||pass.equals("")||repass.equals(""))
            {
                Toast.makeText(addcustomerapagej.this,"Fill All the Fields.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(pass.equals(repass))
                {
                    Boolean result = MyDb.checkusername(usern);
                    if(!result)
                    {
                        Boolean regresult = MyDb.insertData(usern,pass);

                        if(regresult){
                            Toast.makeText(addcustomerapagej.this,"Customer Registration Successful",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),mainadminpanelj.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(addcustomerapagej.this,"Customer Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(addcustomerapagej.this,"Customer Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(addcustomerapagej.this,"Password not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
