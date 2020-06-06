package com.example.anny.ui.loginsiginup.signup

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.anny.R
import com.example.anny.databinding.FragmentSignUpBinding
import com.example.anny.ui.base.BaseBindingFragment
import com.example.anny.ui.utils.Boast
import com.example.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.coroutines.launch

class SignUpFragment : BaseBindingFragment<FragmentSignUpBinding>() {
    override val content: Int
        get() = R.layout.fragment_sign_up

    override fun viewModelSetUp() {
    }

    private val navController
        get() = requireParentFragment().findNavController()

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), false, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolBar)
            }
        }
        btnSignUp.setOnClickListener {
            Boast.makeText(requireContext(), "Signup complete", Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }

}