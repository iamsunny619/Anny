package com.starter.anny.domain.shopandpickup

import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity

interface ShopAndPickRepository {

    suspend fun getShopAndPickUpStores(city: String): List<GetShopAndPickUpStoresEntity>?
}