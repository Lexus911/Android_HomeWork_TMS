package com.example.android_homework.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentNestedBinding
import com.example.android_homework.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NestedFragment : Fragment(), NestedView {

    private var _viewBinding: FragmentNestedBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var nestedPresenter: NestedPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentNestedBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nestedPresenter.setView(this)

        viewBinding.btnBackToLogin.setOnClickListener {
            nestedPresenter.backToLogin()
        }
    }

    override fun backToLogin() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

}