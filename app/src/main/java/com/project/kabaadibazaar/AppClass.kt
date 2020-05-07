package com.project.kabaadibazaar

import android.app.Application

class AppClass : Application() {
    companion object {
        private var instance: AppClass? = null

        @JvmStatic
        fun getInstance(): AppClass {
            return instance as AppClass
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}