package com.starter.anny.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.starter.anny.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseBindingBottomSheetDialog<B : ViewDataBinding> : BottomSheetDialogFragment(),
    HasAndroidInjector {

    var androidInjector: DispatchingAndroidInjector<Any>? = null
        @Inject get

    abstract val contentView: Int
        @LayoutRes get

    private var _binding: B? = null
    val binding: B
        get() = _binding ?: throw IllegalStateException(
            "binding is not available before onCreateView() and in or after onDestroyView()"
        )

    abstract fun viewModelSetup()

    abstract fun viewSetup()

    override fun androidInjector(): AndroidInjector<Any>? {
        return androidInjector
    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<B>(
        inflater,
        contentView,
        container,
        false
    ).also {
        it.lifecycleOwner = this
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelSetup()
        viewSetup()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}