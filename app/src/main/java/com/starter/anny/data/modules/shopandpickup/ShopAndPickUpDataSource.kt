package com.starter.anny.data.modules.shopandpickup

import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData

interface ShopAndPickUpDataSource {

    suspend fun getShopAndPickupStores(city: String): List<GetShopAndPickUpStoresRespData>?
}