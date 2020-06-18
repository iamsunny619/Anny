package com.starter.anny.data.util

import com.starter.anny.data.core.remote.response.BaseDataResponse
import com.starter.anny.data.core.remote.response.BaseResponse

fun <T> BaseDataResponse<T?>.toDataOrError(): T? {
    return if (success) responseData else throw ResponseExecption(message)
}

fun BaseResponse.toMessageOrError(): String? {
    return if (success) message else throw ResponseExecption(message)
}