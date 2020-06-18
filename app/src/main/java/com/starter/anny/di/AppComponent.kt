package com.starter.anny.di

import com.starter.anny.BaseApp
import com.starter.anny.di.modules.ActivityModule.ActivityModule
import com.starter.anny.di.modules.AppModule
import com.starter.anny.di.modules.DataModule
import com.starter.anny.di.modules.ViewModelModule.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApp> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<BaseApp>
}