package com.example.anny.ui.loginsiginup

import android.os.Bundle
import com.example.anny.R
import com.example.anny.databinding.ActivityLoginBinding
import com.example.anny.ui.base.BaseBindingActivity
import timber.log.Timber

class LoginActivity : BaseBindingActivity<ActivityLoginBinding>() {
    override val contentView: Int
        get() = R.layout.activity_login

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        Timber.d("LoginHostActivity created")
    }

    override fun createSavedInstanceState(savedInstanceState: Bundle?) {

    }


}