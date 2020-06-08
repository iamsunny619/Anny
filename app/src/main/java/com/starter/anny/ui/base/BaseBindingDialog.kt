package com.starter.anny.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.starter.anny.R

import dagger.android.support.DaggerDialogFragment

abstract class BaseBindingDialog<B : ViewDataBinding> : DaggerDialogFragment() {

    abstract val contentView: Int
        @LayoutRes get

    private var _binding: B? = null
    val binding: B
        get() = _binding ?: throw IllegalStateException(
            "binding is not available before onCreateView() and in or after onDestroyView()"
        )

    abstract fun viewModelSetup()

    abstract fun viewSetup()

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

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            it.window?.setLayout(width, height)
        }
    }

    fun showProgressDialog() {
        ProgressDialogFragment().show(childFragmentManager, ProgressDialogFragment.TAG)
    }

    fun hideProgressDialog() {
        ((childFragmentManager.findFragmentByTag(ProgressDialogFragment.TAG)) as? DialogFragment)?.dismiss()
    }

    override fun getTheme() = R.style.MoreCorneredDialogTheme

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