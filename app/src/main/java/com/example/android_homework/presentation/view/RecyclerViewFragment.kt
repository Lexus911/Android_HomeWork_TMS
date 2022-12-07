package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.android_homework.presentation.ItemsViewModel
import com.example.android_homework.R
import com.example.android_homework.presentation.adapter.ItemsAdapter
import com.example.android_homework.databinding.FragmentRecyclerViewBinding
import com.example.android_homework.presentation.adapter.listener.ItemsListener

const val KEY_IMAGE_TITLE = "imageTitle"
const val KEY_TITLE = "title"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME = "time"
const val details = "details"

class RecyclerViewFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    private var _viewBinding: FragmentRecyclerViewBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRecyclerViewBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.bundle.observe(viewLifecycleOwner){ navBundle ->

            if(navBundle != null) {
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()

                bundle.putInt(KEY_IMAGE_TITLE, navBundle.imageTitle)
                bundle.putString(KEY_TITLE, navBundle.title)
                bundle.putString(KEY_DESCRIPTION, navBundle.description)
                bundle.putString(KEY_TIME, navBundle.time)

                detailsFragment.arguments = bundle

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, detailsFragment)
                    .addToBackStack(details)
                    .commit()

                viewModel.userNavigated()
            }
        }

    }

    override fun onClick() {

    }

    override fun onElementSelected(imageTitle: Int, title: String, description: String, time: String) {
    viewModel.elementClicked(imageTitle,title,description,time)
    }
}