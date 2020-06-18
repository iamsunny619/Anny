package com.starter.anny.domain.shopandpickup.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


@Keep
data class GetShopAndPickUpStoresEntity(
    val bpId: String?, // BPTNR165028897835462
    val categories: List<Category?>?,
    val city: String?, // Blacksburg
    val imageURL: String?, // https://offer-templates-resized.s3-us-west-2.amazonaws.com/bpservices/Ambika-indian-grocery.jpg
    val retailerName: String?, // Ambika Indian Grocery
    val state: String?, // Virginia
    val storeAddress: String?, // 4520 Brambleton Ave
    val storeid: String?, // BPTNR165028897835462-13314
    val zipcode: String? // 24018
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        TODO("categories"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bpId)
        parcel.writeString(city)
        parcel.writeString(imageURL)
        parcel.writeString(retailerName)
        parcel.writeString(state)
        parcel.writeString(storeAddress)
        parcel.writeString(storeid)
        parcel.writeString(zipcode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GetShopAndPickUpStoresEntity> {
        override fun createFromParcel(parcel: Parcel): GetShopAndPickUpStoresEntity {
            return GetShopAndPickUpStoresEntity(parcel)
        }

        override fun newArray(size: Int): Array<GetShopAndPickUpStoresEntity?> {
            return arrayOfNulls(size)
        }
    }
}