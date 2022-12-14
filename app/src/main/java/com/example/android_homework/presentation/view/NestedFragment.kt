package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_homework.databinding.FragmentNestedBinding
import com.example.android_homework.presentation.NestedViewModel

class NestedFragment : Fragment() {

    private var _viewBinding: FragmentNestedBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: NestedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentNestedBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nav.observe(viewLifecycleOwner) {
            Navigator.replace(parentFragmentManager,LoginFragment(),false)
        }

        viewBinding.btnBackToLogin.setOnClickListener {
            viewModel.backToLoginButtonClick()
        }

    }

}