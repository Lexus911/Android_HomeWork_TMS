package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.adapter.ItemsAdapter
import com.example.android_homework.listener.ItemsListener



class RecyclerViewFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.bundle.observe(viewLifecycleOwner){ navBundle ->
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
                .addToBackStack(KEY_BACKSTACK_NAME)
                .commit()
        }

    }

    override fun onClick() {

    }

    override fun onElementSelected(imageTitle: Int, title: String, description: String, time: String) {
    viewModel.elementClicked(imageTitle,title,description,time)
    }
}