package com.starter.anny.data.modules.tmdbModule.local

import androidx.annotation.StringDef

const val PREF_AUTH_TOKEN = "PREF_AUTH_TOKEN"
const val PREF_LOGIN_DATA = "PREF_LOGIN_DATA"

@StringDef(
    value = [PREF_AUTH_TOKEN, PREF_LOGIN_DATA]
)
@Retention(AnnotationRetention.SOURCE)
annotation class OffersPreferencesKey