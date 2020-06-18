package com.starter.anny.data.modules.shopandpickup.remote

import com.starter.anny.data.core.remote.service.CommonService
import com.starter.anny.data.modules.shopandpickup.ShopAndPickUpDataSource
import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData
import com.starter.anny.data.util.NetworkErrorInterCeptor
import com.starter.anny.data.util.toDataOrError

class RemoteShopAndPickUpDataSource(networkErrorInterCeptor: NetworkErrorInterCeptor) :
    ShopAndPickUpDataSource,
    CommonService<ShopAndPickUpService>(networkErrorInterCeptor) {

    override val baseClass = ShopAndPickUpService::class.java

    override suspend fun getShopAndPickupStores(city: String) =
        networkService.getShopAndPickStores(city).toDataOrError()
}