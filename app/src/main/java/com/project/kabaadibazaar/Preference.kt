package com.project.kabaadibazaar

import android.content.Context
import android.content.SharedPreferences

class Preference {
    private val IS_LOGIN = "IS_LOGIN"

    private val mPrefs: SharedPreferences

    init {
        val application = AppClass.getInstance()
        mPrefs = application.getSharedPreferences("Career_Counselling", Context.MODE_PRIVATE)
    }

    companion object {
        private var instance: Preference? = null

        @JvmStatic
        fun getInstance(): Preference {
            if (instance == null) {
                instance = Preference()
            }
            return instance as Preference
        }
    }

    var isLogin: Boolean
        get() = mPrefs.getBoolean(IS_LOGIN, false)
        set(isLogIn) = mPrefs.edit().putBoolean(IS_LOGIN, isLogIn).apply()
}