package com.rivvana.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "myDatabase.db", null, 21);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists mytable(id integer primary key autoincrement, title text, message text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists mytable");
        onCreate(db);

    }

    public void insertData(Data data){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", data.getTitle());
        contentValues.put("message", data.getMessage());
        long mytable = sqLiteDatabase.insert("mytable", null, contentValues);
        Log.e(TAG, "insertData: "+mytable );

    }
}
