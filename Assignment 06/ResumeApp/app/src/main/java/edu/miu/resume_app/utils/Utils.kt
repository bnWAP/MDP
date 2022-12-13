package edu.miu.resume_app.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

object Utils {
    val LIGHT = "light"
    val DARK = "dark"
}

class AppUtils {
    companion object {

        fun getSharedPref(context: Activity): SharedPreferences {
            return context.getPreferences(Context.MODE_PRIVATE)
        }

        fun getPref(key: String, context: Activity): String? {
            return context.getPreferences(Context.MODE_PRIVATE).getString(key, "")
        }

        fun decideTheme(theme: String) {
            if (theme == Utils.DARK) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}


