package com.example.assignmentLowes.utils

import android.app.Application
import android.content.Context

/**
 * @author Nayana S <nethragowda6@gmail.com>
 * @version 1.0, $date 2021/29/06 10:00 AM
 */
class ApplicationClass : Application() {

    companion object {
        lateinit var instance: Application

        fun getContext(): Context {
            return instance
        }

    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

}