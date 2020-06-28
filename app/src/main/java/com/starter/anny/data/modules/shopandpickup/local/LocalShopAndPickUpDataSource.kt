package com.starter.anny.data.modules.shopandpickup.local

import com.starter.anny.data.core.local.BasePersistence
import com.starter.anny.data.core.local.BasePreferences
import com.starter.anny.data.modules.shopandpickup.ShopAndPickUpDataSource
import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData
import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespDataTesting

class LocalShopAndPickUpDataSource(shopAndPickUpPreferences: ShopAndPickUpPreferences) :
    BasePersistence<ShopAndPickUpPreferences>(shopAndPickUpPreferences), ShopAndPickUpDataSource {

    override suspend fun getShopAndPickupStores(city: String): GetShopAndPickUpStoresRespDataTesting {
        TODO("Not yet implemented")
    }
}