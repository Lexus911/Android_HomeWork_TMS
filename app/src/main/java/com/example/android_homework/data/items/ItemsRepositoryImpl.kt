package com.example.android_homework.data.items

import com.example.android_homework.R
import com.example.android_homework.domain.items.ItemsRepository
import com.example.android_homework.presentation.model.ItemsModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


class ItemsRepositoryImpl @Inject constructor(): ItemsRepository {
    override suspend fun getData(): List<ItemsModel> {
        val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        return listOf(
            ItemsModel(
                R.drawable.we_are_the_champions,
                "We are the champions",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.we_will_rock_you,
                "We will rock you",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.radio_ga_ga, "Radio ga ga", "Album: The Works - 1984", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.i_want_it_all, "I want it all", "Album: The Miracle - 1989", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.bohemian_rhapsody,
                "We are the champions",
                "Album: A night at the Opera - 1975",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.the_show_must_go_on,
                "We are the champions",
                "Album: Innuendo - 1991",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.we_are_the_champions,
                "We are the champions",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.we_will_rock_you,
                "We will rock you",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.radio_ga_ga, "Radio ga ga", "Album: The Works - 1984", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.i_want_it_all, "I want it all", "Album: The Miracle - 1989", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.bohemian_rhapsody,
                "We are the champions",
                "Album: A night at the Opera - 1975",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.the_show_must_go_on,
                "We are the champions",
                "Album: Innuendo - 1991",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.we_are_the_champions,
                "We are the champions",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.we_will_rock_you,
                "We will rock you",
                "Album: New of the World - 1977",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.radio_ga_ga, "Radio ga ga", "Album: The Works - 1984", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.i_want_it_all, "I want it all", "Album: The Miracle - 1989", time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.bohemian_rhapsody,
                "We are the champions",
                "Album: A night at the Opera - 1975",
                time,
                R.drawable.white_star
            ),
            ItemsModel(
                R.drawable.the_show_must_go_on,
                "We are the champions",
                "Album: Innuendo - 1991",
                time,
                R.drawable.white_star
            )
        )
    }

}