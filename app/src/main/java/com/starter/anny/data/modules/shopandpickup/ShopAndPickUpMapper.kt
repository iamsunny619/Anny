package com.starter.anny.data.modules.shopandpickup

import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity

fun List<GetShopAndPickUpStoresRespData>?.mapShopAndPickUpStores() = this?.map {
    it.run {
        it.run {
            GetShopAndPickUpStoresEntity(bpId, categories?.map { category ->
                category?.run {
                    GetShopAndPickUpStoresEntity.Category(
                        categoryId,
                        categoryName,
                        count,
                        subCategories?.map { subCategory ->
                            subCategory?.run {
                                GetShopAndPickUpStoresEntity.Category.SubCategory(
                                    categoryId,
                                    count,
                                    subCategoryId,
                                    subCategoryName
                                )
                            }
                        })
                }
            }, city, imageURL, retailerName, state, storeAddress, storeid, zipcode)
        }
    }
}