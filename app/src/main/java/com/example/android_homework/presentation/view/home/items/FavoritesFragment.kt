package com.example.android_homework.presentation.view.home.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_homework.App
import com.example.android_homework.databinding.FragmentFavoritesBinding
import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.view.home.items.adapter.FavoritesAdapter
import com.example.android_homework.presentation.view.home.items.adapter.FavoritesListener
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


class FavoritesFragment : Fragment(), FavoritesListener,FavoritesView {

    @Inject
    lateinit var favoritesPresenter: FavoritesPresenter
    private lateinit var favAdapter: FavoritesAdapter

    private var _viewBinding: FragmentFavoritesBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFavoritesBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        favoritesPresenter.setView(this)

        favAdapter = FavoritesAdapter(this)

        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerView.adapter = favAdapter


//        favoritesPresenter.getFavorites()

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            favoritesPresenter.favoritesItems.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
                .collect{ flowList ->
                    flowList.collect{ list ->
                        favAdapter.submitList(list)
                    }
                }
        }
    }

    override fun favReceived(list: List<FavoritesModel>) {
        favAdapter.submitList(list)
    }

    override fun onDeleteClicked(id: Int) {
        favoritesPresenter.deleteFavItem(id)
    }
}