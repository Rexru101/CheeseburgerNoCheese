package com.rexru.cheeseburgernocheese;

import android.app.Application;

/*
 * Created by Rexru101 on 5/3/2015.
 */
public class MyApplication extends Application
{
    private static MyApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance()
    {
        return instance;
    }
}