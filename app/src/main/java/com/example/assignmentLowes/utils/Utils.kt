package com.example.assignmentLowes.utils

import android.content.Context
import android.net.ConnectivityManager

class Utils {

    companion object {
        fun isNetworkAvailable(): Boolean {
            val conMan = ApplicationClass.getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return conMan.activeNetworkInfo != null && conMan.activeNetworkInfo!!
                    .isConnected
        }
    }
}