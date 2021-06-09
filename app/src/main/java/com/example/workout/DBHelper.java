package com.example.workout;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;


//model class for database
public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context,"bmi",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {

    }

    public ArrayList<String> getAllBMis()
    {
        ArrayList<String> array_list =  new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from bmi_table", null);
        res.moveToFirst();
        while(res.isAfterLast() == false)
        {
            array_list.add(res.getString(res.getColumnIndex("bmi_values")));
            res.moveToNext();
        }
        return array_list;
    }
public ArrayList<String> getAllTimestamps() // gets current time and date
{
    ArrayList<String> array_list = new ArrayList<>();

    SQLiteDatabase db = this.getReadableDatabase();
    Cursor res = db.rawQuery("select * from bmi_table", null);
    res.moveToFirst();
    while (res.isAfterLast() == false)
    {
        array_list.add(res.getString(res.getColumnIndex("Insertion_date")));
        res.moveToNext();
    }
    return array_list;
}

}
