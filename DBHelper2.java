package com.example.animalapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper2 extends SQLiteOpenHelper {
    public DBHelper2(Context context) { super(context, "animaldata.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase animaldb) {
        animaldb.execSQL("create Table animal(Fusername, animalId Text primary key, animalnm Text ,medicine Text, vaccine Text, reason text, date text, time text, mobno text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase animaldb, int i, int i1) {
        animaldb.execSQL("drop Table if exists animal");
    }

    public Boolean insertData(String Fusername, String animalId, String animalnm, String medicine ,String vaccine, String reason, String date, String time, String mobno){
        SQLiteDatabase animaldb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Fusername",Fusername);
        contentValues.put("animalId",animalId);
        contentValues.put("animalnm",animalnm);
        contentValues.put("medicine",medicine);
        contentValues.put("vaccine",vaccine);
        contentValues.put("reason",reason);
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("mobno",mobno);

        long result = animaldb.insert("animal",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean checkanimalid(String animalId){
        SQLiteDatabase animaldb =  this.getWritableDatabase();
        Cursor cursor = animaldb.rawQuery("select * from animal where animalId = ?", new String[] {animalId});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Cursor getData()
    {
        SQLiteDatabase animaldb = this.getWritableDatabase();
        Cursor cursor = animaldb.rawQuery("select * from animal",null);
        return cursor;
    }

}