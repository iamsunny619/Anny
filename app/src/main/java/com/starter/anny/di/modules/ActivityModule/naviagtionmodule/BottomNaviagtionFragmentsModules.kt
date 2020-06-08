package com.starter.anny.di.modules.ActivityModule.naviagtionmodule

import com.starter.anny.di.scope.FragmentScoped
import com.starter.anny.ui.bottomnav.explore.ExploreFragment
import com.starter.anny.ui.bottomnav.games.GameListFragment
import com.starter.anny.ui.bottomnav.chatt.ChattWithUsFragment
import com.starter.anny.ui.bottomnav.takepicture.PictureFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BottomNaviagtionFragmentsModules {

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeProfileFragment(): ChattWithUsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeGameListFragment(): GameListFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributePictureFragment(): PictureFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeExploreFragment(): ExploreFragment

}