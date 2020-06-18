package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName

@Keep
data class GetShopAndPickUpStoresData(
    val bpId: String?, // BPTNR165028897835462
    val categories: List<Category?>?,
    val city: String?, // Blacksburg
    val imageURL: String?, // https://offer-templates-resized.s3-us-west-2.amazonaws.com/bpservices/Ambika-indian-grocery.jpg
    val retailerName: String?, // Ambika Indian Grocery
    val state: String?, // Virginia
    val storeAddress: String?, // 4520 Brambleton Ave
    val storeid: String?, // BPTNR165028897835462-13314
    val zipcode: String? // 24018
) {
    @Keep
    data class Category(
        val categoryId: String?, // 101
        val categoryName: String?, // Beverages
        val count: String?, // 3
        val subCategories: List<SubCategory?>?
    ) {
        @Keep
        data class SubCategory(
            val categoryId: String?, // 101
            val count: String?, // 7
            val subCategoryId: String?, // 11
            val subCategoryName: String? // Juices & Concentrates
        )
    }
}