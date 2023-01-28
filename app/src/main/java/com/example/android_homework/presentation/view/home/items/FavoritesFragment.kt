package com.example.android_homework.presentation.view.home.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_homework.databinding.FragmentFavoritesBinding
import com.example.android_homework.presentation.model.FavoritesModel
import com.example.android_homework.presentation.view.home.items.adapter.FavoritesAdapter
import com.example.android_homework.presentation.view.home.items.adapter.FavoritesListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
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

        favoritesPresenter.setView(this)

        favAdapter = FavoritesAdapter(this)

        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerView.adapter = favAdapter


        favoritesPresenter.getFavorites()

    }

    override fun favReceived(list: List<FavoritesModel>) {
        favAdapter.submitList(list)
    }

    override fun onDeleteClicked(id: Int) {
        favoritesPresenter.deleteFavItem(id)
    }
}