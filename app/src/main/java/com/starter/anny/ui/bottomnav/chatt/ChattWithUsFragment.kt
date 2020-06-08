package com.starter.anny.ui.bottomnav.chatt

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import android.view.View
import com.starter.anny.R
import com.starter.anny.databinding.FragmentProfileBinding
import com.starter.anny.ui.base.BaseBindingFragment
import com.starter.anny.ui.utils.Boast
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.*

class ChattWithUsFragment : BaseBindingFragment<FragmentProfileBinding>(), View.OnClickListener {
    override val content: Int
        get() = R.layout.fragment_profile

    override fun viewModelSetUp() {

    }

    override fun viewSetUp() {
        fbtnSpeek.setOnClickListener(this)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            619 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val spokenText: String? =
                        data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                            .let { results ->
                                results?.let { results[0] }
                            }
                    txtData.setText(spokenText)
                    //  txtData.setSelection(tieSpeechToText.text?.length ?: 0)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fbtnSpeek -> {
                getSpeechInput()
            }
        }
    }

    private fun getSpeechInput() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        if (intent.resolveActivity(requireContext().packageManager) != null) {
            startActivityForResult(intent, 619)
        } else {
            Boast.showText(
                requireContext(),
                getText(R.string.your_device_dont_support_speech_input)
            )
        }
    }

}
