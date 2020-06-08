package com.starter.anny.ui.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


object PermissionUtils {

    fun hasPermission(context: Context, permission: String): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) return true // must be granted after installed.
        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun hasPermissions(
        context: Context?,
        vararg permissions: String?
    ): Boolean {
        context?.let {
            for (permission in permissions) {
                if (permission?.let { checkPermission ->
                        ActivityCompat.checkSelfPermission(
                            context,
                            checkPermission
                        )
                    } != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }

}