package com.starter.anny.di.modules

import com.starter.anny.data.modules.shopandpickup.ShopAndPickUpDataSourceRepository
import com.starter.anny.domain.shopandpickup.ShopAndPickRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ShopAndPickUpModule {

    @Provides
    @Singleton
    fun provideOfferDataRepository(shopAndPickUpDataSourceRepository: ShopAndPickUpDataSourceRepository): ShopAndPickRepository =
        shopAndPickUpDataSourceRepository
}