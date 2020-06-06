package com.example.anny.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseBindingActivity<B : ViewDataBinding> : DaggerAppCompatActivity() {

    abstract val contentView: Int
        @LayoutRes get

    abstract fun viewModelSetUp()
    abstract fun viewSetUp()
    abstract fun createSavedInstanceState(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<B>(this, contentView)
        createSavedInstanceState(savedInstanceState)
        viewModelSetUp()
        viewSetUp()
    }

}