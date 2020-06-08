package com.starter.anny

import android.content.Context
import androidx.multidex.MultiDex
import com.starter.anny.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        Fresco.initialize(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}