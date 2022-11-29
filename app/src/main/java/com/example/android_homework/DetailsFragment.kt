package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsImageTitle = view.findViewById<ImageView>(R.id.details_imageTitle)
        val detailsTitle = view.findViewById<TextView>(R.id.details_title)
        val detailsDescription = view.findViewById<TextView>(R.id.details_description)
        val detailsTime = view.findViewById<TextView>(R.id.details_time)


        val bundle = arguments
        bundle?.let {safeBundle ->

            val title = bundle.getString("title")
            val description = bundle.getString("description")
            val time = bundle.getString("time")
            val imageTitle = bundle.getInt("imageTitle")

            detailsTitle.text = title
            detailsDescription.text = description
            detailsTime.text = time
            detailsImageTitle.setBackgroundResource(imageTitle)
        }
    }
}