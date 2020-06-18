package com.starter.anny.data.modules.shopandpickup.remote.response

import androidx.annotation.Keep
import com.starter.anny.data.core.remote.response.BaseDataResponse
import com.starter.anny.data.modules.shopandpickup.model.GetShopAndPickUpStoresRespData

@Keep
data class GetShopAndPickUpResponse(override val responseData: List<GetShopAndPickUpStoresRespData>?) :
    BaseDataResponse<List<GetShopAndPickUpStoresRespData>?>()