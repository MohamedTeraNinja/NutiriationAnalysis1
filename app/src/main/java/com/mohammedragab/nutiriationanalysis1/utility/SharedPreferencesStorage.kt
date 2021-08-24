package com.mohammedragab.nutiriationanalysis1.utility
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

import javax.inject.Singleton

@Singleton
class SharedPreferencesStorage @Inject constructor( val context: Context) {

    val sharedPreferences: SharedPreferences
        get()=(context as Context).getSharedPreferences("com.mohammedragab.nutiriationanalysis1", Context.MODE_PRIVATE)

    fun  clearData(){
        with(sharedPreferences.edit()){
            clear().apply()
        }
    }
}