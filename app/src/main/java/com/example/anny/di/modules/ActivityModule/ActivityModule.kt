package com.example.anny.di.modules.ActivityModule

import com.example.anny.di.modules.ActivityModule.fragmentmodule.AccountFragmentModule
import com.example.anny.di.modules.ActivityModule.fragmentmodule.ShopAndOrderFragmentModule
import com.example.anny.di.modules.ActivityModule.naviagtionmodule.BottomNaviagtionFragmentsModules
import com.example.anny.di.scope.ActivityScoped
import com.example.anny.ui.SplashActivity
import com.example.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderHostActivity
import com.example.anny.ui.loginsiginup.LoginActivity
import com.example.anny.ui.sidedrawer.DrawerHomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector
    fun contributeSplashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [BottomNaviagtionFragmentsModules::class])
    fun contributeDrawerHomeActivity(): DrawerHomeActivity


    @ActivityScoped
    @ContributesAndroidInjector(modules = [AccountFragmentModule::class])
    fun contributeLoginActivity(): LoginActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ShopAndOrderFragmentModule::class])
    fun contributeShopAndOrderHostActivity(): ShopAndOrderHostActivity

}