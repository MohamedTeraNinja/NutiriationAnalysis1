package com.teraninjas.mazadat.utility

import android.content.Context
import android.graphics.Color.green
import android.icu.text.CaseMap
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mohammedragab.nutiriationanalysis1.R

object Utile {

    fun showSucesSnakbar(view: View,text:String,){
        Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
            .setAction("Ok") {
                // Responds to click on the action
            }
            .setBackgroundTint(ContextCompat.getColor(view.context, R.color.purple_500))
            .setActionTextColor(ContextCompat.getColor(view.context,R.color.black))
            .show()

    }

    fun showErrorSnakbar(view: View,text:String,){
        Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE)
            .setAction("Ok") {
                // Responds to click on the action
            }
            .setBackgroundTint(ContextCompat.getColor(view.context,R.color.red))
            .setActionTextColor(ContextCompat.getColor(view.context,R.color.black))
            .show()

    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            } else {
                TODO("VERSION.SDK_INT < M")
            }
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }else{
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    val URL="https://api.edamam.com/"
    
  

}