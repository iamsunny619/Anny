package com.example.anny.di.modules.ActivityModule.naviagtionmodule

import com.example.anny.di.scope.FragmentScoped
import com.example.anny.ui.bottomnav.explore.ExploreFragment
import com.example.anny.ui.bottomnav.games.GameListFragment
import com.example.anny.ui.bottomnav.chatt.ChattWithUsFragment
import com.example.anny.ui.bottomnav.takepicture.PictureFragment
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