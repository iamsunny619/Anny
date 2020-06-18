package com.starter.anny.data.util

import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

class NetworkErrorInterCeptor(
    private val cm: ConnectivityManager,
    private val noNetworkMsg: String,
    private val errorCodeToMsg: Map<Int, String>
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!cm.hasNetwork()) throw NoNetworkException(noNetworkMsg)
        val response = chain.proceed(chain.request())
        return if (response.isSuccessful || !errorCodeToMsg.containsKey(response.code)) {
            response
        } else {
            throw ResponseExecption(errorCodeToMsg[response.code])
        }
    }

}