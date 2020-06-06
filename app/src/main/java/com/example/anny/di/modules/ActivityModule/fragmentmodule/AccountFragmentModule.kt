package com.example.anny.di.modules.ActivityModule.fragmentmodule

import com.example.anny.di.scope.FragmentScoped
import com.example.anny.ui.loginsiginup.login.LoginFragment
import com.example.anny.ui.loginsiginup.signup.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AccountFragmentModule {

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeLoginFragment(): LoginFragment

    @FragmentScoped
    @ContributesAndroidInjector
    fun contributeSignUpFragment(): SignUpFragment

}