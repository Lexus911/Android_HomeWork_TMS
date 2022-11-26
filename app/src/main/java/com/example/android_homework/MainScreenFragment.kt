package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, NestedFragment())
            .commit()

        val  dialog = AlertDialog.Builder(requireContext())
            .setTitle("Congratulations!")
            .setMessage("Welcome to WeWillRockYou.com\nWe are glad to see you with us")
            .setCancelable(false)
            .setPositiveButton("OK"){dialog, _ ->
                Toast.makeText(requireContext(), "called ok", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }
        dialog.show()
    }
}