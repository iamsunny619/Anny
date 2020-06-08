package com.starter.anny.ui.utils.app

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Build
import android.util.Base64
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.FragmentActivity
import com.starter.anny.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import timber.log.Timber
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


object AppUtils {

    @SuppressLint("PackageManagerGetSignatures")
    fun printHashKey(requireActivity: FragmentActivity?) {
        // Add code to print out the key hash
        try {
            val info: PackageInfo = requireActivity?.packageManager?.getPackageInfo(
                "com.gobaskt",
                PackageManager.GET_SIGNATURES // for api 28 PackageManager.GET_SIGNING_CERTIFICATES
            )!!
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Timber.d("KeyHash: ${Base64.encodeToString(md.digest(), Base64.DEFAULT)}")
            }
        } catch (e: NameNotFoundException) {
            e.printStackTrace()
            Timber.d(e.message.toString())
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            Timber.d(e.message.toString())
        } catch (e: Exception) {
            e.printStackTrace()
            Timber.d(e.message.toString())
        }
    }

    // set transparent status bar color
    @SuppressLint("ObsoleteSdkInt")
    fun setTransparentStatusColor(
        activity: Activity,
        isWhiteText: Boolean,
        color: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            when {
                Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP_MR1 -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = getColor(
                        activity,
                        if (isWhiteText) R.color.transparent else R.color.gray
                    )
                }
                Build.VERSION.SDK_INT < Build.VERSION_CODES.M -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = getColor(activity, color)
                }
                else -> {
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.statusBarColor = getColor(activity, color)
                }
            }
            setSystemBarTheme(
                activity,
                isWhiteText
            )
        }
    }

    fun dpToPx(context: Context?, valueInDp: Float): Float {
        val metrics = context?.resources?.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics)
    }


    private fun setSystemBarTheme(
        pActivity: Activity,
        pIsDark: Boolean
    ) {
        val lFlags = pActivity.window.decorView.systemUiVisibility
        pActivity.window.decorView.systemUiVisibility =
            if (pIsDark) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                lFlags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else {
                TODO("VERSION.SDK_INT < M")
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                lFlags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                TODO("VERSION.SDK_INT < M")
            }
    }

    // A method to find height of the status bar
    fun getStatusBarHeight(activity: Activity?): Int {
        var result = 0
        val resourceId: Int =
            activity?.resources?.getIdentifier("status_bar_height", "dimen", "android") ?: 0
        if (resourceId > 0) {
            result = activity?.resources?.getDimensionPixelSize(resourceId) ?: 0
        }
        return result
    }


    //below all are method which need there res colors and style add them by uncoment all and start


//    fun showSnackBar(activity: Activity?, message: CharSequence?) {
//        val rootView = activity?.window?.decorView
//            ?.findViewById<View>(android.R.id.content)
//        rootView?.let {
//            val snackBar = Snackbar.make(it, message.toString(), Snackbar.LENGTH_SHORT)
//                .setActionTextColor(getColor(activity, R.color.orange_d85b00))
//
//            val snackBarView = snackBar.view
//            //snackBarView.setBackgroundColor(getColor(activity, R.color.blue_1dc6fe))
//            val textView = snackBarView.findViewById(
//                com.google.android.material.R.id.snackbar_text
//            ) as TextView
//            textView.maxLines = 3
//            textView.setTextColor(getColor(activity, R.color.white))
//            snackBar.show()
//        }
//    }
//
//    fun showSnackBarWithAction(
//        activity: Activity?, message: CharSequence?, actionName: String?,
//        itemClick: () -> Unit
//    ) {
//        val rootView = activity?.window?.decorView
//            ?.findViewById<View>(android.R.id.content)
//        rootView?.let {
//            val snackBar: Snackbar =
//                Snackbar.make(it, message.toString(), Snackbar.LENGTH_SHORT)
//                    .setActionTextColor(getColor(activity, R.color.colorAccent))
//                    .setAction(actionName) {
//                        itemClick.invoke()
//                    }
//
//            val snackBarView = snackBar.view
//            //snackBarView.setBackgroundColor(getColor(activity, R.color.blue_1dc6fe))
//            val textView = snackBarView.findViewById(
//                com.google.android.material.R.id.snackbar_text
//            ) as TextView
//            textView.maxLines = 2
//            textView.setTextColor(getColor(activity, R.color.colorPrimary))
//            snackBar.show()
//        }
//    }
//
//
    fun okDialog(context: Context, message: String?, onOkClick: () -> Unit) {
        MaterialAlertDialogBuilder(
            context,
            R.style.MaterialAlertDialogRoundedStyle
        )
            .setTitle(context.getText(R.string.app_name))
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(context.getText(R.string.ok)) { dialog, _ ->
                dialog.dismiss()
                onOkClick.invoke()
            }
            .show()
    }

//    fun okCancelDialog(context: Context?, message: String?, onOkClick: () -> Unit) {
//        MaterialAlertDialogBuilder(
//            context,
//            R.style.MaterialAlertDialogRoundedStyle
//        )
//            .setTitle(context?.getText(R.string.app_name))
//            .setMessage(message)
//            .setCancelable(false)
//            .setPositiveButton(context?.getText(R.string.ok)) { dialog, _ ->
//                dialog.dismiss()
//                onOkClick.invoke()
//            }
//            .setNegativeButton(context?.getText(R.string.cancel)) { dialog, _ ->
//                dialog.dismiss()
//            }
//            .show()
//    }
//
//    fun okCancelCustomTitleDialog(
//        context: Context?,
//        title: String?,
//        message: String?,
//        onOkClick: () -> Unit
//    ) {
//        MaterialAlertDialogBuilder(
//            context,
//            R.style.MaterialAlertDialogRoundedStyle
//        )
//            .setTitle(title)
//            .setMessage(message)
//            .setCancelable(false)
//            .setPositiveButton(context?.getText(R.string.ok)) { dialog, _ ->
//                dialog.dismiss()
//                onOkClick.invoke()
//            }
//            .setNegativeButton(context?.getText(R.string.cancel)) { dialog, _ ->
//                dialog.dismiss()
//            }
//            .show()
//    }
//
//    fun customDialog(
//        context: Context?,
//        title: String?,
//        positiveText: String?,
//        negativeText: String?,
//        message: String?,
//        isCancelable: Boolean,
//        onOkClick: () -> Unit
//    ) {
//        MaterialAlertDialogBuilder(
//            context,
//            R.style.MaterialAlertDialogRoundedStyle
//        )
//            .setTitle(title)
//            .setMessage(message)
//            .setCancelable(isCancelable)
//            .setPositiveButton(positiveText) { dialog, _ ->
//                dialog.dismiss()
//                onOkClick.invoke()
//            }
//            .setNegativeButton(negativeText) { dialog, _ ->
//                dialog.dismiss()
//            }
//            .show()
//    }
//
//    fun resolveOrThrow(context: Context, @AttrRes attributeResId: Int): Int {
//        val typedValue = TypedValue()
//        if (context.theme.resolveAttribute(attributeResId, typedValue, true)) {
//            return typedValue.data
//        }
//        throw IllegalArgumentException(context.resources.getResourceName(attributeResId))
//    }

}