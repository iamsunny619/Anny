package com.starter.anny.domain.shopandpickup

import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntityTesting

interface ShopAndPickRepository {

    suspend fun getShopAndPickUpStores(city: String):GetShopAndPickUpStoresEntityTesting?
}