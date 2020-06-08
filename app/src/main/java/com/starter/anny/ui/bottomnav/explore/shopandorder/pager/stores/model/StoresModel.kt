package com.starter.anny.ui.bottomnav.explore.shopandorder.pager.stores.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class StoresModel(
    @DrawableRes val productImage: Int,
    val shopName: String?,
    val shopAddress: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(productImage)
        parcel.writeString(shopName)
        parcel.writeString(shopAddress)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoresModel> {
        override fun createFromParcel(parcel: Parcel): StoresModel {
            return StoresModel(parcel)
        }

        override fun newArray(size: Int): Array<StoresModel?> {
            return arrayOfNulls(size)
        }
    }
}