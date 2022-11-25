package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class RegistrationFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registration, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toTheMainScreen = view.findViewById<Button>(R.id.btn_SignUp)

        val editText3 = view.findViewById<TextInputEditText>(R.id.et_text3)
        val editText4 = view.findViewById<TextInputEditText>(R.id.et_text4)

        toTheMainScreen.setOnClickListener {

            if (editText3.text.toString().isEmpty()) {
                editText3.error = "field e-mail cant be empty"

            } else if (editText4.text.toString().isEmpty()) {
                editText4.error = "field password can't be empty"
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
            }
        }
    }

}