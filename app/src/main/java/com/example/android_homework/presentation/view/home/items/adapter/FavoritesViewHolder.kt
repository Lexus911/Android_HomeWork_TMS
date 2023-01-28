package com.example.android_homework.presentation.view.home.items.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.databinding.ItemFavoritesBinding
import com.example.android_homework.presentation.model.FavoritesModel

class FavoritesViewHolder(
    private val viewBinding: ItemFavoritesBinding,
    private val favoritesListener: FavoritesListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(favItems: FavoritesModel) {

        viewBinding.tvName.text = "Name: " + favItems.name
        viewBinding.tvUsername.text = "Username: " + favItems.username
        viewBinding.tvEmail.text = "E-mail: " + favItems.email
        viewBinding.tvPhone.text = "Phone: " + favItems.phone
        viewBinding.tvAddress.text = "Address: " + favItems.city + ", " + favItems.street + "str., " + favItems.suite
        viewBinding.tvZipcode.text = "Zipcode: " + favItems.zipcode
        viewBinding.tvCompany.text = "Company: " + favItems.nameCompany
        viewBinding.tvGeo.text = "Geolocation: lat: " + favItems.lat+ ", lng: " + favItems.lng
        viewBinding.tvWebsite.text = "Website " + favItems.website
        viewBinding.tvBs.text = "Business: " + favItems.bs
        viewBinding.tvCatchPhrase.text = "Catch phrase: " + favItems.catchPhrase

        viewBinding.ivDeleteFav.setOnClickListener{
            favoritesListener.onDeleteClicked(favItems.id)
        }
    }
}