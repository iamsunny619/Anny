package com.starter.anny.ui.loginsiginup

import android.os.Bundle
import com.starter.anny.R
import com.starter.anny.databinding.ActivityLoginBinding
import com.starter.anny.ui.base.BaseBindingActivity
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