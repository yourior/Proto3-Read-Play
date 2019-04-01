package com.example.entre31proto3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseRegister extends SQLiteOpenHelper
{
    public static final String Database_Name = "register.db" ;
    public static final String Table_Name = "registeruser" ;
    public static final String Column_1 = "ID" ;
    public static final String Column_2 = "Username" ;
    public static final String Column_3 = "Password" ;

    public DatabaseRegister(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table registeruser (ID Integer Primary Key AUTOINCREMENT , Username TEXT , Password TEXT  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(sqLiteDatabase);
    }
    public long addUser(String user, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UserName",user);
        contentValues.put("Password", password);
        long res = db.insert("registeruser",null, contentValues);
        db.close();
        return res;
    }

    public boolean CheckUser(String user , String password)
    {
        String[] columns = {Column_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = Column_2 + "=?" + "and" + Column_3 + "=?";
        String[] selectionArgs ={user , password};
        Cursor cursor = db.query(Table_Name,columns,selection,selectionArgs,null,null,null);
        int count =cursor.getCount();
        db.close();

        if(count>0)
        {
            return true;
        }else
        {
            return false;
        }

    }


}
