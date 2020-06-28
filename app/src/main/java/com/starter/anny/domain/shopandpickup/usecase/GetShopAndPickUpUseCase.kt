package com.starter.anny.domain.shopandpickup.usecase

import com.starter.anny.domain.UseCase
import com.starter.anny.domain.shopandpickup.ShopAndPickRepository
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntity
import com.starter.anny.domain.shopandpickup.entity.GetShopAndPickUpStoresEntityTesting
import javax.inject.Inject

class GetShopAndPickUpUseCase @Inject constructor(private val shopAndPickRepository: ShopAndPickRepository) :
    UseCase<GetShopAndPickUpUseCase.Params, GetShopAndPickUpStoresEntityTesting?> {
    override suspend fun invoke(params: GetShopAndPickUpUseCase.Params) =
        shopAndPickRepository.getShopAndPickUpStores(params.city)

    class Params(val city: String)

}