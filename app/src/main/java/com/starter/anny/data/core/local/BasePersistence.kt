package com.starter.anny.data.core.local

import android.content.SharedPreferences

abstract class BasePersistence<Pref : BasePreferences>(protected val sharedPreferences: Pref)