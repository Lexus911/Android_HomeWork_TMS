package com.example.android_homework.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.databinding.ItemsSongsBinding
import com.example.android_homework.presentation.adapter.listener.ItemsListener
import com.example.android_homework.presentation.model.ItemsModel

class ItemsAdapter(private var itemsListener: ItemsListener): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = listOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>){
        this.listItems = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemsSongsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}