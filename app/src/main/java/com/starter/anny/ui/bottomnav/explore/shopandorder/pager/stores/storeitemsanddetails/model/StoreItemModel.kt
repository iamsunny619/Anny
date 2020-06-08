package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.storeitemsanddetails.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class StoreItemModel(
    val itemName: String?,
    val itemDescription: String?,
    val itemQuantity: String?,
    val itemPrice: Int?,
    @DrawableRes val itemImage: Int?
) : Parcelable {
    var itemCount: Int? = 0
    var itemChanged: Boolean = false

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
        itemCount = parcel.readValue(Int::class.java.classLoader) as? Int
        itemChanged = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(itemName)
        parcel.writeString(itemDescription)
        parcel.writeString(itemQuantity)
        parcel.writeValue(itemPrice)
        parcel.writeValue(itemImage)
        parcel.writeValue(itemCount)
        parcel.writeByte(if (itemChanged) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoreItemModel> {
        override fun createFromParcel(parcel: Parcel): StoreItemModel {
            return StoreItemModel(parcel)
        }

        override fun newArray(size: Int): Array<StoreItemModel?> {
            return arrayOfNulls(size)
        }
    }
}