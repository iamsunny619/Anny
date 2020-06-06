package com.example.anny.ui.base

import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.anny.R
import com.example.anny.ui.utils.Truss


abstract class BaseBindingFragment<BF : ViewDataBinding> : BaseFragment() {

    private var _binding: BF? = null

    val binding: BF
        get() = _binding
            ?: throw IllegalStateException("binding is not available before onCreateView() and in or after onDestroyView()")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<BF>(inflater, content, container, false).also {
        it.lifecycleOwner = this
        _binding = it
    }.root

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
        _binding = null
    }

//below is for the use for the .. dont know

    fun <B : ViewDataBinding> BaseBindingFragment<B>.getStringWithAesterisk(
        charSequence: CharSequence?,
        hintColor: Int,
        aesteriskColor: Int
    ): CharSequence? {
        return Truss().pushSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(
                    requireContext(),
                    hintColor
                )
            )
        )
            .append(charSequence)
            .popSpan()
            .pushSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), aesteriskColor)))
            .append(getString(R.string.asterick_operator))
            .popSpan()
            .build()
    }

}