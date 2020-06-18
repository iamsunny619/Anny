package com.starter.anny.data.util

import android.net.ConnectivityManager

fun ConnectivityManager?.hasNetwork(): Boolean {
    return this?.activeNetworkInfo?.isConnected ?: false
}