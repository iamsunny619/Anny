package com.starter.anny.data.modules.tmdbModule.local

import android.content.SharedPreferences
import com.google.gson.Gson
import com.starter.anny.data.core.local.BasePreferences

class TmdbPopularMoviePrefernces(sharedPreferences: SharedPreferences, private val gson: Gson) :
    BasePreferences(sharedPreferences) {
}