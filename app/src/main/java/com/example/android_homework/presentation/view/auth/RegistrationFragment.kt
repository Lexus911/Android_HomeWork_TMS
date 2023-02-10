package com.example.android_homework.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_homework.App
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentRegistrationBinding
import com.example.android_homework.presentation.model.UsersModel
import com.example.android_homework.utils.NavHelper.setGraph
import javax.inject.Inject

class RegistrationFragment : Fragment(), RegistrationView {

    private var _viewBinding: FragmentRegistrationBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var registrationPresenter: RegistrationPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRegistrationBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        registrationPresenter.setView(this)

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
                registrationPresenter.registerUser(
                    UsersModel(
                        null,
                        viewBinding.etText5.text.toString(),
                        viewBinding.etText3.text.toString(),
                        viewBinding.etText6.text.toString(),
                        viewBinding.etText4.text.toString()
                    )
                )
            }
        }
    }

    override fun userRegisteredIn() {
        setGraph(R.navigation.main_graph)
    }
}