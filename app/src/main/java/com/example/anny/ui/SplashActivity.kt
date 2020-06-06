package com.example.anny.ui

import android.content.Intent
import android.os.Bundle
import com.example.anny.ui.loginsiginup.LoginActivity
import com.example.anny.ui.sidedrawer.DrawerHomeActivity
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}