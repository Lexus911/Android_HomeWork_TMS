package com.example.android_homework.presentation.view.home.items.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.databinding.ItemFavoritesBinding
import com.example.android_homework.presentation.model.FavoritesModel


class FavoritesAdapter(
    private var favoritesListener: FavoritesListener
): RecyclerView.Adapter<FavoritesViewHolder>() {

    private var listItems = listOf<FavoritesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<FavoritesModel>){

        this.listItems = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val viewBinding = ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FavoritesViewHolder(viewBinding, favoritesListener)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}