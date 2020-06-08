package com.starter.anny.di.modules

import android.app.Application
import com.starter.anny.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {
    // all the instance that will be use by whole project that is singleton instances like retrofit, glide and all

    @Singleton
    @Provides
    fun provideApplication(app: BaseApp): Application = app


}