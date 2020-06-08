package com.starter.anny.di.modules.ActivityModule

import com.starter.anny.di.modules.ActivityModule.fragmentmodule.AccountFragmentModule
import com.starter.anny.di.modules.ActivityModule.fragmentmodule.ShopAndOrderFragmentModule
import com.starter.anny.di.modules.ActivityModule.naviagtionmodule.BottomNaviagtionFragmentsModules
import com.starter.anny.di.scope.ActivityScoped
import com.starter.anny.ui.SplashActivity
import com.starter.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderHostActivity
import com.starter.anny.ui.loginsiginup.LoginActivity
import com.starter.anny.ui.sidedrawer.DrawerHomeActivity
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