package com.starter.anny.di.modules.ActivityModule.fragmentmodule

import com.starter.anny.di.scope.FragmentScoped
import com.starter.anny.ui.bottomnav.explore.tmdb.module.TmdbHomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface TmdbFragmentModule {
    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeTmdbHomeFragment(): TmdbHomeFragment
}