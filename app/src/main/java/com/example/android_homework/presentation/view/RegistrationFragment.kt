package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private var _viewBinding: FragmentRegistrationBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRegistrationBinding.inflate(inflater)
        return viewBinding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnSignUp.setOnClickListener {
            if (viewBinding.etText5.text.toString().isEmpty()) {
                viewBinding.etText5.error = getString(R.string.error_field_firstname)

            } else if (viewBinding.etText3.text.toString().isEmpty()) {
                viewBinding.etText3.error = getString(R.string.error_field_email)

            } else if (viewBinding.etText6.text.toString().isEmpty()) {
                viewBinding.etText6.error = getString(R.string.error_field_username)

            } else if (viewBinding.etText4.text.toString().isEmpty()) {
                viewBinding.etText4.error = getString(R.string.error_field_password)
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
            }
        }
    }

}