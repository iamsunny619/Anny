package com.starter.anny.data.core.remote.service

import android.net.Network
import androidx.annotation.CallSuper
import com.starter.anny.data.util.NetworkErrorInterCeptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

abstract class CommonService<T>(private val networkErrorInterceptor: NetworkErrorInterCeptor) :
    BaseService<T>() {

    override val BASEURL = "https://api.gobaskt.com/"

    @CallSuper
    override fun handleOkHttBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return super.handleOkHttBuilder(builder)
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .addInterceptor(networkErrorInterceptor)
    }
}