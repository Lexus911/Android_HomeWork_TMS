package com.example.android_homework.presentation.view.home.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentRecyclerViewBinding
import com.example.android_homework.presentation.adapter.ItemsAdapter
import com.example.android_homework.presentation.adapter.listener.ItemsListener
import com.example.android_homework.presentation.model.ItemsModel
import com.example.android_homework.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

const val KEY_IMAGE_TITLE = "imageTitle"
const val KEY_TITLE = "title"
const val KEY_DESCRIPTION = "description"
const val KEY_TIME = "time"

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

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

        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemsPresenter.getData()
        }


        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemsPresenter.listItems.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
                .collect{ flowList ->
                    flowList.collect{ list ->
                        itemsAdapter.submitList(list)
                    }
                }
        }


    }

    override fun onElementSelected(name: String, username: String, email: String) {
        itemsPresenter.elementSelected(name, username, email)
    }

    override fun onFavClicked(id: Int) {
        itemsPresenter.onFavClicked(id)
    }

    override fun onDeleteClicked(id: Int) {
        itemsPresenter.deleteItem(id)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun goToDetails(name: String, username: String, email: String) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()


        bundle.putString(KEY_TITLE, name)
        bundle.putString(KEY_DESCRIPTION, username)
        bundle.putString(KEY_TIME, email)

        detailsFragment.arguments = bundle

        navigateWithBundle(R.id.action_itemsFragment_to_detailsFragment, bundle)

    }

}