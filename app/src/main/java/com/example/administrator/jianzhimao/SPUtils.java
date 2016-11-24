package com.example.administrator.jianzhimao;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/11/16.
 */

public class SPUtils {
    public static boolean putBoolean(Context context, String fileName, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }


    public static boolean getBoolean(Context context, String fileName, String key) {
        return getBoolean(context, fileName, key, false);
    }


    public static boolean getBoolean(Context context, String fileName, String key, boolean defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }
}
