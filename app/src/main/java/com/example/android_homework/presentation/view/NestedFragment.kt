package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentNestedBinding

class NestedFragment : Fragment() {

    private var _viewBinding: FragmentNestedBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentNestedBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnBackToLogin.setOnClickListener {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
        }
    }

}