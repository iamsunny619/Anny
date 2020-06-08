package com.starter.anny.ui

import android.content.Intent
import android.os.Bundle
import com.starter.anny.R
import com.starter.anny.ui.loginsiginup.LoginActivity
import com.starter.anny.ui.utils.app.AppUtils
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppUtils.setTransparentStatusColor(this@SplashActivity, true, R.color.orange)

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}