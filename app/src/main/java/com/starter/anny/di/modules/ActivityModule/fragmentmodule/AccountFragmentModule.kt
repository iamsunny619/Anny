package com.starter.anny.di.modules.ActivityModule.fragmentmodule

import com.starter.anny.di.scope.FragmentScoped
import com.starter.anny.ui.loginsiginup.login.LoginFragment
import com.starter.anny.ui.loginsiginup.signup.SignUpFragment
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