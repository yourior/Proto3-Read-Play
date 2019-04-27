package com.example.entre31proto3;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class StillLogin  {

    static final String StayUserName= "username";
    static final String StayUserCredit = "usercredit";
    static SharedPreferences.Editor editor;



    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName, String userCredit)
    {
        editor = getSharedPreferences(ctx).edit();
        editor.putString(StayUserName, userName);
        editor.putString(StayUserCredit, userCredit);
        editor.commit();

    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(StayUserName, "");
    }
    public static String getUSerCredit(Context ctx)
    {
        return getSharedPreferences(ctx).getString(StayUserCredit, "");
    }

    public static void Logout(Context ctx)
    {
        editor = getSharedPreferences(ctx).edit();
        editor.clear(); //clear all stored data
        editor.commit();
    }

    public void LogChanger()
    {

    }

}
