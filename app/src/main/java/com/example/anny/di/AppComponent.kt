package com.example.anny.di

import com.example.anny.BaseApp
import com.example.anny.di.modules.ActivityModule.ActivityModule
import com.example.anny.di.modules.AppModule
import com.example.anny.di.modules.ViewModelModule.ViewModelModule
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
        ActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApp> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<BaseApp>
}