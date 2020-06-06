package com.example.anny.di.modules.ActivityModule.fragmentmodule

import com.example.anny.di.scope.FragmentScoped
import com.example.anny.ui.bottomnav.explore.shopandorder.ShopAndOrderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ShopAndOrderFragmentModule {
    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeShopAndOrderFragment(): ShopAndOrderFragment
}