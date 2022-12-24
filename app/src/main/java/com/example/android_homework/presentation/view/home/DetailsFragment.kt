package com.example.android_homework.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentDetailsBinding
import com.example.android_homework.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let {safeBundle ->
            detailsPresenter.getDetails(
            bundle.getString(KEY_TITLE),
            bundle.getString(KEY_DESCRIPTION),
            bundle.getString(KEY_TIME),
            bundle.getInt(KEY_IMAGE_TITLE)
            )
        }

        viewBinding.btnLogout.setOnClickListener{
            detailsPresenter.logoutUser()
        }
    }

    override fun userLoggedOut() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

    override fun displayDetails(title: String, description: String, time: String, imageTitle: Int) {
        viewBinding.detailsTitle.text = title
        viewBinding.detailsDescription.text = description
        viewBinding.detailsTime.text = time
        viewBinding.detailsImageTitle.setBackgroundResource(imageTitle)
    }
}