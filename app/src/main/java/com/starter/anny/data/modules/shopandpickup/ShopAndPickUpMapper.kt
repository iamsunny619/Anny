package com.starter.anny.data.modules.shopandpickup

import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData
import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespDataTesting
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntityTesting

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

fun GetShopAndPickUpStoresRespDataTesting?.mapShopData() = this?.run {
    GetShopAndPickUpStoresEntityTesting(message,responseData?.map { responseData ->
        responseData?.run {
            GetShopAndPickUpStoresEntityTesting.ResponseData(bpId,categories?.map { category ->
                category?.run {
                    GetShopAndPickUpStoresEntityTesting.ResponseData.Category(categoryId,categoryName,count,subCategories?.map {subCategory ->
                        subCategory?.run {
                            GetShopAndPickUpStoresEntityTesting.ResponseData.Category.SubCategory(categoryId,count,subCategoryId,subCategoryName)
                        }
                    })
                }
            },city,imageURL,retailerName,state,storeAddress,storeid,zipcode)
        }
    },statusCode,success)
}