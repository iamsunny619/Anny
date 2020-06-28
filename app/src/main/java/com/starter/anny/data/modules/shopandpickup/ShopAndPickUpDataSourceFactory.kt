package com.starter.anny.data.modules.shopandpickup

import android.content.SharedPreferences
import com.google.gson.Gson
import com.starter.anny.data.core.BaseDataSourceFactory
import com.starter.anny.data.modules.shopandpickup.local.LocalShopAndPickUpDataSource
import com.starter.anny.data.modules.shopandpickup.local.ShopAndPickUpPreferences
import com.starter.anny.data.modules.shopandpickup.remote.RemoteShopAndPickUpDataSource
import com.starter.anny.data.util.NetworkErrorInterCeptor
import javax.inject.Inject

class ShopAndPickUpDataSourceFactory @Inject constructor(
    sharedPreferences: SharedPreferences,
    gson: Gson,
    networkErrorInterCeptor: NetworkErrorInterCeptor
) :
    BaseDataSourceFactory<ShopAndPickUpDataSource>() {
    override val localDataSource: ShopAndPickUpDataSource = LocalShopAndPickUpDataSource(
        ShopAndPickUpPreferences(sharedPreferences, gson)
    )

    override val remoteDataSource: ShopAndPickUpDataSource =
        RemoteShopAndPickUpDataSource(networkErrorInterCeptor)
}