package com.starter.anny.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.starter.anny.R
import com.starter.anny.data.util.NetworkErrorInterCeptor
import dagger.Module
import dagger.Provides
import java.net.HttpURLConnection
import javax.inject.Singleton

@Module
class DataRepositoryModule {

    @Provides
    @Singleton
    fun provideConnectivityManager(app: Application): ConnectivityManager {
        return app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Singleton
    @Provides
    fun provideNetworkErrorInterceptor(
        app: Application,
        connectivityManager: ConnectivityManager
    ) = NetworkErrorInterCeptor(
        connectivityManager, app.getString(R.string.error_no_network),
        mapOf(
            // no need to write 401 because it is handled manually
            HttpURLConnection.HTTP_BAD_REQUEST to app.getString(R.string.error_bad_request),
            HttpURLConnection.HTTP_INTERNAL_ERROR to app.getString(R.string.error_internal_error)
        )
    )

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideContentResolver(app: Application) = app.contentResolver
}