package com.example.android_homework.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.R
import com.example.android_homework.listener.ItemsListener
import com.example.android_homework.model.ItemsModel

class ItemsViewHolder(private val view: View,
                      private var itemsListener: ItemsListener
): RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel){
        val imageTitle = view.findViewById<ImageView>(R.id.iv_title)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val description = view.findViewById<TextView>(R.id.tv_description)
        val time = view.findViewById<TextView>(R.id.tv_time)
        val imageStar = view.findViewById<ImageView>(R.id.iv_star1)

        imageTitle.setBackgroundResource(itemsModel.imageTitle)
        title.text = itemsModel.title
        description.text = itemsModel.description
        time.text = itemsModel.time
        imageStar.setBackgroundResource(itemsModel.imageStar)

        var changeStar = true

        imageStar.setOnClickListener{
            when(changeStar){
            true -> {imageStar.setImageResource(R.drawable.yellow_star)
                changeStar = false}
            false -> {imageStar.setImageResource(R.drawable.white_star)
                changeStar = true}
            }
        }

        itemView.setOnClickListener{
            itemsListener.onElementSelected(itemsModel.imageTitle , itemsModel.title, itemsModel.description, itemsModel.time)
        }
    }
}