package com.starter.anny.data.modules.shopandpickup

import com.starter.anny.domain.shopandpickup.ShopAndPickRepository
import javax.inject.Inject

class ShopAndPickUpDataSourceRepository @Inject constructor(private val shopAndPickUpDataSourceFactory: ShopAndPickUpDataSourceFactory) :
    ShopAndPickRepository {

    override suspend fun getShopAndPickUpStores(city: String) =
        shopAndPickUpDataSourceFactory.remoteDataSource
            .getShopAndPickupStores(city)
            .mapShopAndPickUpStores()
}