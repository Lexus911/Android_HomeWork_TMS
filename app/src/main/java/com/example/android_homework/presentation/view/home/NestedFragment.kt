package com.example.android_homework.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_homework.App
import com.example.android_homework.databinding.FragmentNestedBinding
import javax.inject.Inject


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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        nestedPresenter.setView(this)

        viewBinding.btnBackToLogin.setOnClickListener {
            nestedPresenter.backToLogin()
        }
    }

    override fun backToLogin() {
//
//        parentFragmentManager
//            .beginTransaction()
//            .replace(R.id.activity_container, LoginFragment())
//            .commit()
    }

}