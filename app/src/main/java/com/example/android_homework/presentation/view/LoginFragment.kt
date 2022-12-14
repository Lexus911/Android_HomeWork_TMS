package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentLoginBinding
import com.example.android_homework.presentation.LoginViewModel

class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.log.observe(viewLifecycleOwner) {
            if (viewBinding.etText.text.toString().isEmpty()) {
                viewBinding.etText.error = getString(R.string.error_field_username)

            } else if (viewBinding.etText2.text.toString().isEmpty()) {
                viewBinding.etText2.error = getString(R.string.error_field_password)
            } else {
                Navigator.replace(parentFragmentManager,MainScreenFragment(),false)
            }
        }

        viewModel.recV.observe(viewLifecycleOwner){
            Navigator.add(parentFragmentManager,RecyclerViewFragment(), true)
        }

        viewModel.reg.observe(viewLifecycleOwner){
            Navigator.add(parentFragmentManager,RegistrationFragment(), true)
        }

        viewBinding.btnRecyclerView.setOnClickListener{
            viewModel.recyclerViewButtonClick()
        }

        viewBinding.btnRegistration.setOnClickListener{
            viewModel.registrationButtonClick()
        }

        viewBinding.btnLogin.setOnClickListener{
            viewModel.loginButtonClick()
        }

    }
}

