package com.example.animalapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class deletecustpagej extends Activity {

    EditText uname;
    ImageButton del;
    DBHelper MyDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletecustomerpage);

        uname = findViewById(R.id.name);
        del = findViewById(R.id.delcustomer);
        MyDb = new DBHelper (this);

        del.setOnClickListener(view -> {
            String user = uname.getText().toString();
            boolean res = MyDb.deleteData(user);
            if(res){
                Toast.makeText(deletecustpagej.this, "Customer deleted successfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(deletecustpagej.this, "Customer not deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
