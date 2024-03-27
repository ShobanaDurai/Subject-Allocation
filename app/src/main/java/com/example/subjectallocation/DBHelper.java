package com.example.subjectallocation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Allocationdetails(course TEXT,subject TEXT,faculty TEXT,subcode TEXT primary key,Class TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Allocationdetails");

    }
    public Boolean insertuserdata(String course,String subject,String faculty,String subcode,String Class){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("course",course);
        contentValues.put("subject",subject);
        contentValues.put("faculty",faculty);
        contentValues.put("subcode",subcode);
        contentValues.put("Class",Class);
        long result = DB.insert("Allocationdetails",null,contentValues);
        if (result ==-1) {
            return false;
        }
        else{
            return true;
        }
    }


    public Boolean updateuserdata(String course,String subject,String faculty,String subcode,String Class){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("course",course);
        contentValues.put("faculty",faculty);
        contentValues.put("subcode",subcode);
        contentValues.put("Class",Class);
        Cursor cursor = DB.rawQuery("Select * from Allocationdetails where subject = ?",new String[] {subject});
        if(cursor.getCount()>0) {
            long result = DB.update("Allocationdetails", contentValues, "subject=?", new String[]{subject});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Boolean deleteuserdata(String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Allocationdetails where subject = ?",new String[] {subject});
        if(cursor.getCount()>0) {
            long result = DB.delete("Allocationdetails", "subject=?", new String[]{subject});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Allocationdetails",null);
        return cursor;
    }
}
