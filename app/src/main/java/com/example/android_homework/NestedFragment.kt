package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class NestedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_nested, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toTheLogin = view.findViewById<Button>(R.id.btn_BackToLogin)

        toTheLogin.setOnClickListener {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
        }
    }

}