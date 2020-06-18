package com.starter.anny.data.modules.shopandpickup.remote

import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData
import com.starter.anny.data.modules.shopandpickup.remote.response.GetShopAndPickUpResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ShopAndPickUpService {

    @GET("dev-retailers/gobaskt/stores/get")
    suspend fun getShopAndPickStores(@Query("city")city:String):GetShopAndPickUpResponse
}