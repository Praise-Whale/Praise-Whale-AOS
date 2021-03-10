package com.example.praisewhale.util

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.Nullable


class MySharedPreferences(context: Context) {

    private val NAME = "SharedPreferences"
    private val MODE = Context.MODE_PRIVATE
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(NAME, MODE)


    fun getValue(key: String, @Nullable defValue: String): String {
        return sharedPreferences.getString(key, defValue).toString()
    }

    fun setValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getBooleanValue(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }

    fun setBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
}
