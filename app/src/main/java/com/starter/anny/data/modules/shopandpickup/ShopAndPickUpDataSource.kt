package com.starter.anny.data.modules.shopandpickup

import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespDataTesting

interface ShopAndPickUpDataSource {

    suspend fun getShopAndPickupStores(city: String): GetShopAndPickUpStoresRespDataTesting
}