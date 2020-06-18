package com.starter.anny.data.core.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
abstract class BaseResponse {
    abstract val success: Boolean
    abstract val message: String?
    abstract val statusCode: Int?
}

@Keep
abstract class BaseDataResponse<T>(
    @SerializedName("success")
    override val success: Boolean = false,
    @SerializedName("message")
    override val message: String? = null,
    @SerializedName("statusCode")
    override val statusCode: Int? = 0
) :
    BaseResponse() {
    abstract val responseData: T?
}

@Keep
data class MessageResponse(
    @SerializedName("success")
    override val success: Boolean = false,
    @SerializedName("message")
    override val message: String? = null,
    @SerializedName("statusCode")
    override val statusCode: Int? = 0
) : BaseResponse()