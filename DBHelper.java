package com.example.animalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDb) {
        MyDb.execSQL("create Table users(username Text primary key, password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDb, int i, int i1) {
        MyDb.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDb.insert("users",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }


    public Boolean checkusername(String username){
        SQLiteDatabase MyDb =  this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase MyDb =  this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean deleteData(String username){
        SQLiteDatabase MyDb =  this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
        {
            long result = MyDb.delete("users","username = ?",new String [] {username});
            if(result == -1){
                return false;
            }
            else {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
}