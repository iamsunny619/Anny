package com.starter.anny.di.modules.ViewModelModule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.starter.anny.di.ViewModelKey
import com.starter.anny.di.viewmodelfactory.ViewModelFactory
import com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.viewmodel.StoreFragmentViewModel
import com.starter.anny.ui.bottomnav.explore.tmdb.module.viewmodel.TmdbHomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StoreFragmentViewModel::class)
    fun bindStoreFragmentViewModel(viewModel: StoreFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TmdbHomeViewModel::class)
    fun bindTmdbHomeViewModel(viewModel: TmdbHomeViewModel):ViewModel

}