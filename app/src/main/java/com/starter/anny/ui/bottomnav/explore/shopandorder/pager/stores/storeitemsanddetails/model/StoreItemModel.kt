package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model

import androidx.annotation.DrawableRes

data class StoreItemModel(
    val itemName: String?,
    val itemDescription: String?,
    val itemQuantity: String?,
    val itemPrice: Int?,
    @DrawableRes val itemImage: Int?
)