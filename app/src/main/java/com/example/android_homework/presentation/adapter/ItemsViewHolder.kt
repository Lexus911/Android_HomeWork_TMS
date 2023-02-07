package com.example.android_homework.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.databinding.ItemsSongsBinding
import com.example.android_homework.presentation.adapter.listener.ItemsListener
import com.example.android_homework.presentation.model.ItemsModel

class ItemsViewHolder(private val viewBinding: ItemsSongsBinding,
                      private var itemsListener: ItemsListener
): RecyclerView.ViewHolder(viewBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(itemsModel: ItemsModel){

        viewBinding.tvName.text = "Name: " + itemsModel.name
        viewBinding.tvUsername.text = "Username: " + itemsModel.username
        viewBinding.tvEmail.text = "E-mail: " + itemsModel.email
        viewBinding.tvPhone.text = "Phone: " + itemsModel.phone
        viewBinding.tvAddress.text = "Address: " + itemsModel.city + ", " + itemsModel.street + "str., " + itemsModel.suite
        viewBinding.tvZipcode.text = "Zipcode: " + itemsModel.zipcode
        viewBinding.tvCompany.text = "Company: " + itemsModel.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + itemsModel.lat+ ", lng: " + itemsModel.lng
        viewBinding.tvWebsite.text = "Website " + itemsModel.website
        viewBinding.tvBs.text = "Business: " + itemsModel.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + itemsModel.catchPhrase

        itemView.setOnClickListener{
            itemsListener.onElementSelected( itemsModel.name, itemsModel.username, itemsModel.email)
        }

        viewBinding.btnFav.setOnClickListener{
            itemsListener.updateFavorite(!itemsModel.favorite, itemsModel.id)

            viewBinding.btnFav.isSelected = itemsModel.favorite

            itemsListener.onFavClicked(itemsModel.id)
        }

        viewBinding.ivDelete.setOnClickListener{
            itemsListener.onDeleteClicked(itemsModel.id)
        }
    }
}