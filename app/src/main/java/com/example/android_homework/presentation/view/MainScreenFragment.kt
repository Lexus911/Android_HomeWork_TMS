package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.android_homework.R


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
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.welcome))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.ok)){ dialog, _ ->
                Toast.makeText(requireContext(), getString(R.string.calle_ok), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                dialog.cancel()
            }

        dialog.show()
    }
}