package com.example.anny.di.modules.ViewModelModule

import androidx.lifecycle.ViewModelProvider
import com.example.anny.di.viewmodelfactory.ViewModelFactory
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