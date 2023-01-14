package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_homework.databinding.FragmentDetailsBinding
import com.example.android_homework.presentation.view.utils.Navigator.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val bundle = arguments
            bundle?.let {
                val title = bundle.getString(KEY_TITLE)
                val description = bundle.getString(KEY_DESCRIPTION)
                val time = bundle.getString(KEY_TIME)
                val imageTitle = bundle.getInt(KEY_IMAGE_TITLE)

                viewBinding.detailsTitle.text = title
                viewBinding.detailsDescription.text = description
                viewBinding.detailsTime.text = time
                viewBinding.detailsImageTitle.setBackgroundResource(imageTitle)
            }
                viewBinding.btnLogout.setOnClickListener {
                    viewModel.logoutUser()
                }

                viewModel.details.observe(viewLifecycleOwner){
                    navigate(it ?: 0)
                }


    }
}