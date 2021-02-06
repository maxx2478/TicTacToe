package com.manohar.tictactoe

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class AppClass: Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}