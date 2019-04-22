package com.example.entre31proto3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseRegister extends SQLiteOpenHelper
{


    public static final String Database_Name = "register.db" ;
    public static final String Table_Name = "registeruser" ;
    public static final String Column_1 = "ID" ;
    public static final String Column_2 = "Username" ;
    public static final String Column_3 = "Password" ;
    public static final String Column_4 = "Money" ;




    public DatabaseRegister(Context context) {

        super(context, Database_Name, null, 1);
       // SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" Create Table "+ Table_Name +" ("+Column_1+" Integer Primary Key AUTOINCREMENT , "+Column_2+" TEXT , "+Column_3+" TEXT ,"+Column_4+" Integer )");
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
        contentValues.put(Column_2, user);
        contentValues.put(Column_3, password);
        long res = db.insert(Table_Name,null, contentValues);
        db.close();
        return res;
    }

    public boolean CheckUser(String user , String password)
    {

//        SQLiteDatabase db = getReadableDatabase();
//
//        String[] columns = {Column_1};
//
//        String selection = Column_2 + "=?" + "and" + Column_3 + "=?";
//        Log.d("selection",selection);
//        String[] selectionArgs ={user , password};
//        //og.d("selection",selectionArgs[0]);
//        Cursor cursor = db.query(Table_Name,columns,selection,selectionArgs,
//                null,null,null);
//        int count =cursor.getCount();
//        cursor.close();
//        db.close();
//
//        if(count>0)
//        {
//            return true;
//        }else
//        {
//            return false;
//        }

        SQLiteDatabase db = this.getWritableDatabase();
        String select = "SELECT * FROM users WHERE NAME ='" + user + "' AND PASSWORD='" + password + "'";

        Cursor c = db.rawQuery(select, null);

        if (c.moveToFirst()) {
            Log.d("Test","User exits");
            return true;
        }

        if(c!=null) {
            c.close();
        }
        db.close();
        return false;
    }


}
