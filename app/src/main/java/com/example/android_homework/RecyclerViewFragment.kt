package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_homework.adapter.ItemsAdapter
import com.example.android_homework.listener.ItemsListener
import com.example.android_homework.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class RecyclerViewFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))

        val listItems = mutableListOf<ItemsModel>(
            ItemsModel(R.drawable.we_are_the_champions, "We are the champions", "Album: New of the World - 1977", time, R.drawable.white_star),
            ItemsModel(R.drawable.we_will_rock_you, "We will rock you", "Album: New of the World - 1977", time, R.drawable.white_star),
            ItemsModel(R.drawable.radio_ga_ga, "Radio ga ga", "Album: The Works - 1984", time, R.drawable.white_star),
            ItemsModel(R.drawable.i_want_it_all, "I want it all", "Album: The Miracle - 1989", time,R.drawable.white_star),
            ItemsModel(R.drawable.bohemian_rhapsody, "We are the champions", "Album: A night at the Opera - 1975", time, R.drawable.white_star),
            ItemsModel(R.drawable.the_show_must_go_on, "We are the champions", "Album: Innuendo - 1991", time, R.drawable.white_star)
        )

        itemsAdapter.submitList(listItems)
    }

    override fun onClick() {

        Toast.makeText(context, "ImageViewClicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(imageTitle: Int, title: String, description: String, time: String) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()

        bundle.putInt("imageTitle", imageTitle)
        bundle.putString("title", title)
        bundle.putString("description", description)
        bundle.putString("time", time)

        detailsFragment.arguments = bundle


        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()

    }
}