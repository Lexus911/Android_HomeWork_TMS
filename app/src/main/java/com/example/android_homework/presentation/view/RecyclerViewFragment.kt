package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.data.ItemsRepositoryImpl
import com.example.android_homework.presentation.adapter.ItemsAdapter
import com.example.android_homework.databinding.FragmentRecyclerViewBinding
import com.example.android_homework.domain.ItemsInteractor
import com.example.android_homework.presentation.ItemsPresenter
import com.example.android_homework.presentation.ItemsView
import com.example.android_homework.presentation.adapter.listener.ItemsListener
import com.example.android_homework.presentation.model.ItemsModel

const val KEY_IMAGE_TITLE = "imageTitle"
const val KEY_TITLE = "title"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME = "time"
const val details = "details"

class RecyclerViewFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    private lateinit var itemsPresenter: ItemsPresenter

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

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()

    }

    override fun onClick() {

    }

    override fun onElementSelected(imageTitle: Int, title: String, description: String, time: String) {
        itemsPresenter.elementSelected(imageTitle,title,description,time)
    }


    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun goToDetails(imageTitle: Int, title: String, description: String, time: String) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()

        bundle.putInt(KEY_IMAGE_TITLE, imageTitle)
        bundle.putString(KEY_TITLE, title)
        bundle.putString(KEY_DESCRIPTION, description)
        bundle.putString(KEY_TIME, time)

        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack(details)
            .commit()
    }
}