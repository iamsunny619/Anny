package com.starter.anny.data.modules.shopandpickup.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GetShopAndPickUpStoresRespData(
    @SerializedName("bpId")
    val bpId: String?, // BPTNR165028897835462
    @SerializedName("categories")
    val categories: List<Category?>?,
    @SerializedName("city")
    val city: String?, // Blacksburg
    @SerializedName("imageURL")
    val imageURL: String?, // https://offer-templates-resized.s3-us-west-2.amazonaws.com/bpservices/Ambika-indian-grocery.jpg
    @SerializedName("retailerName")
    val retailerName: String?, // Ambika Indian Grocery
    @SerializedName("state")
    val state: String?, // Virginia
    @SerializedName("storeAddress")
    val storeAddress: String?, // 4520 Brambleton Ave
    @SerializedName("storeid")
    val storeid: String?, // BPTNR165028897835462-13314
    @SerializedName("zipcode")
    val zipcode: String? // 24018
) {
    @Keep
    data class Category(
        @SerializedName("categoryId")
        val categoryId: String?, // 101
        @SerializedName("categoryName")
        val categoryName: String?, // Beverages
        @SerializedName("count")
        val count: String?, // 3
        @SerializedName("subCategories")
        val subCategories: List<SubCategory?>?
    ) {
        @Keep
        data class SubCategory(
            @SerializedName("categoryId")
            val categoryId: String?, // 101
            @SerializedName("count")
            val count: String?, // 7
            @SerializedName("subCategoryId")
            val subCategoryId: String?, // 11
            @SerializedName("subCategoryName")
            val subCategoryName: String? // Juices & Concentrates
        )
    }
}