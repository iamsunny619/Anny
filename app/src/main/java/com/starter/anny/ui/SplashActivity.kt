package com.starter.anny.ui

import android.content.Intent
import android.os.Bundle
import com.starter.anny.ui.loginsiginup.LoginActivity
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}