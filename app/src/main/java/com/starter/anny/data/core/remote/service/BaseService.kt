package com.starter.anny.data.core.remote.service

import androidx.annotation.CallSuper
import com.google.gson.GsonBuilder
import com.starter.anny.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseService<T> {

    private var _networkService: T? = null

    protected abstract val BASEURL: String

    protected abstract val baseClass: Class<T>

    protected val networkService: T
        get() {
            var service = _networkService
            return if (service == null) {
                service = initalizeNetworkService()
                _networkService = service
                return service
            } else service
        }

    private fun initalizeNetworkService(): T {
        return handleRetrofitBuilder(Retrofit.Builder().baseUrl(BASEURL))
            .addConverterFactory(GsonConverterFactory.create(handleGson(GsonBuilder()).create()))
            .client(getOkHttpClient())
            .build()
            .create(baseClass)

    }

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return handleOkHttBuilder(OkHttpClient.Builder())
            .addInterceptor(httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
            }).build()
    }

    @CallSuper
    protected open fun handleRetrofitBuilder(builder: Retrofit.Builder) = builder

    @CallSuper
    protected open fun handleGson(builder: GsonBuilder) = builder

    @CallSuper
    protected open fun handleOkHttBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder
    }


}

