package com.example.anny.ui.loginsiginup.login

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.anny.R
import com.example.anny.databinding.FragmentLoginBinding
import com.example.anny.ui.base.BaseBindingFragment
import com.example.anny.ui.sidedrawer.DrawerHomeActivity
import com.example.anny.ui.utils.app.AppUtils
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.launch

class LoginFragment : BaseBindingFragment<FragmentLoginBinding>(), View.OnClickListener {
    override val content: Int
        get() = R.layout.fragment_login

    private val navController
        get() = requireParentFragment().findNavController()

    override fun viewModelSetUp() {
    }

    override fun viewSetUp() {
        AppUtils.setTransparentStatusColor(requireActivity(), false, R.color.orange)
        lifecycleScope.launch {
            (requireActivity() as AppCompatActivity).apply {
                setSupportActionBar(toolBar)
            }
        }
        btnLogin.setOnClickListener(this)
        btnSignUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                startActivity(Intent(requireContext(), DrawerHomeActivity::class.java))
                requireActivity().finish()
            }
            R.id.btnSignUp -> {
                navController.navigate(R.id.action_loginFragment_to_signUpFragment)
            }
        }
    }


}