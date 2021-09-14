package com.example.practiceapp

import android.content.SharedPreferences

class SharedPref(private val sharedPreferences: SharedPreferences) {

    fun setThemeMode(themeModes: ThemeModes) {
        sharedPreferences.edit().putInt(THEME_KEY, themeModes.ordinal).apply()
    }

    fun getThemeMode(): ThemeModes {
        val ordinal = sharedPreferences.getInt(THEME_KEY, 0)
        return ThemeModes.values()[ordinal]
    }

    fun setFontType(fontTypes: FontTypes) {
        sharedPreferences.edit().putInt(FONT_KEY, fontTypes.ordinal).apply()
    }

    fun getFontType(): FontTypes {
        val ordinal = sharedPreferences.getInt(FONT_KEY, 0)
        return FontTypes.values()[ordinal]
    }

    companion object {
        const val SETTINGS_SP = "SETTINGS_SP"
        private const val THEME_KEY = "THEME_KEY"
        private const val FONT_KEY = "FONT_KEY"
    }

}