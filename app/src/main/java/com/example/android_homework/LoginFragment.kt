package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toTheMainScreen = view.findViewById<Button>(R.id.btn_Login)
        val toTheRegistration = view.findViewById<Button>(R.id.btn_Registration)

        toTheRegistration.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, RegistrationFragment())
                .addToBackStack("login_screen")
                .commit()
        }

        val editText = view.findViewById<TextInputEditText>(R.id.et_text)
        val editText2 = view.findViewById<TextInputEditText>(R.id.et_text2)


        toTheMainScreen.setOnClickListener{

            if(editText.text.toString().isEmpty()){
                editText.error = "field e-mail can't be empty"

            }else if(editText2.text.toString().isEmpty()){
                editText2.error = "field password can't be empty"
            }
            else {
                parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, MainScreenFragment())
                .commit()
            }

        }


    }

}

