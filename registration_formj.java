package com.example.animalapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;

public class registration_formj extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText username, aid, a_name, medicine, vaccine, date, time, reason, ph_no;
    private int year, month, day, hour, minute;

    Button setd,sett;
    ImageButton reg_btn;
    DBHelper2 animaldb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("System Notification","Notify", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        username = findViewById(R.id.Fusername);
        aid = findViewById(R.id.animalId);
        a_name = findViewById(R.id.animalnm);
        medicine = findViewById(R.id.medicine);
        vaccine = findViewById(R.id.vaccine);
        reason = findViewById(R.id.reason);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        ph_no = findViewById(R.id.mobno);
        reg_btn = findViewById(R.id.reg_form_btn);
        setd = findViewById(R.id.setdate);
        sett = findViewById(R.id.settime);

        animaldb = new DBHelper2 (this);

        setd.setOnClickListener(view -> {
            Calendar cal = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            day = cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(registration_formj.this, registration_formj.this, year, month, day);
            datePickerDialog.show();
        });

        sett.setOnClickListener(view -> {
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(registration_formj.this, registration_formj.this, hour, minute, DateFormat.is24HourFormat(registration_formj.this));
            timePickerDialog.show();
        });

        reg_btn.setOnClickListener(view -> {

            String uname = username.getText().toString();
            String a_id = aid.getText().toString();
            String aname = a_name.getText().toString();
            String med = medicine.getText().toString();
            String vaccination = vaccine.getText().toString();
            String v_reason = reason.getText().toString();
            String dt = date.getText().toString();
            String tm = time.getText().toString();
            String num = ph_no.getText().toString();

            if(uname.equals("")||a_id.equals("")||aname.equals("")||med.equals("")||vaccination.equals("")||v_reason.equals("")||dt.equals("")||tm.equals("")||num.equals(""))
            {
                Toast.makeText(registration_formj.this,"Fill All the Fields.",Toast.LENGTH_SHORT).show();
            }
            else if(num.length() != 10)
            {
                Toast.makeText(registration_formj.this,"Mobile number should be 10 digits.",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Boolean Form_result = animaldb.checkanimalid(a_id);
                if(!Form_result)
                {
                    Boolean res = animaldb.insertData(uname,a_id,aname,med,vaccination,v_reason,dt,tm,num);
                    if(res){
                        Toast.makeText(registration_formj.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),userpanelj.class);
                        startActivity(intent);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(registration_formj.this,"System Notification");
                        builder.setContentTitle("Animal System");
                        builder.setContentText(" APPOINT BOOKED AT "+dt+"\n BE THERE BEFORE "+tm);
                        builder.setSmallIcon(R.drawable.icon);
                        builder.setAutoCancel(true);
                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(registration_formj.this);
                        managerCompat.notify(1,builder.build());

                    }
                    else {
                        Toast.makeText(registration_formj.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(registration_formj.this,"petId Already registered\n Please enter another id " ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        year = i;
        month = i1;
        day = i2;
        date.setText(day + "/" + (month+1) + "/" + year);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hour = i;
        minute = i1;
        time.setText( hour + ":" + minute);
    }
}