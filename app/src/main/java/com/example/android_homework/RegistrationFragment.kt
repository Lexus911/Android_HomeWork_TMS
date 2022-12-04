package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

const val ErrorFieldE_mail = "field e-mail can't be empty"
const val ErrorFiledFirstname = "field first name can't be empty"

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
        val editText5 = view.findViewById<TextInputEditText>(R.id.et_text5)
        val editText6 = view.findViewById<TextInputEditText>(R.id.et_text6)

        toTheMainScreen.setOnClickListener {
            if (editText5.text.toString().isEmpty()) {
                editText5.error = ErrorFiledFirstname

            } else if (editText3.text.toString().isEmpty()) {
                editText3.error = ErrorFieldE_mail

            } else if (editText6.text.toString().isEmpty()) {
                editText6.error = ErrorFieldUsername

            } else if (editText4.text.toString().isEmpty()) {
                editText4.error = ErrorFieldPassword
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
            }
        }
    }

}