package com.starter.anny.di.modules.ViewModelModule

import androidx.lifecycle.ViewModelProvider
import com.starter.anny.di.viewmodelfactory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory



    /*   @Binds
       @IntoMap
       @ViewModelKey(classNameViewMOdel::class)
       fun bindLocalOffersViewModel(viewModel: classNameViewMOdel): ViewModel*/
}