package com.example.android_homework.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.R
import com.example.android_homework.databinding.ItemsSongsBinding
import com.example.android_homework.presentation.adapter.listener.ItemsListener
import com.example.android_homework.presentation.model.ItemsModel

class ItemsViewHolder(private val viewBinding: ItemsSongsBinding,
                      private var itemsListener: ItemsListener
): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel){

        viewBinding.ivTitle.setBackgroundResource(itemsModel.imageTitle)
        viewBinding.tvTitle.text = itemsModel.title
        viewBinding.tvDescription.text = itemsModel.description
        viewBinding.tvTime.text = itemsModel.time
        viewBinding.ivStar.setBackgroundResource(itemsModel.imageStar)

        var changeStar = true

        viewBinding.ivStar.setOnClickListener{
            when(changeStar){
            true -> {viewBinding.ivStar.setImageResource(R.drawable.yellow_star)
                changeStar = false}
            false -> {viewBinding.ivStar.setImageResource(R.drawable.white_star)
                changeStar = true}
            }
        }

        itemView.setOnClickListener{
            itemsListener.onElementSelected(itemsModel.imageTitle , itemsModel.title, itemsModel.description, itemsModel.time)
        }
    }
}