package com.example.android_homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

const val ErrorFieldUsername = "field username can't be empty"
const val ErrorFieldPassword = "field password can't be empty"
const val BackstackLogin = "login_screen"

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
        val toTheRecyclerView = view.findViewById<Button>(R.id.btn_RecyclerView)


        toTheRecyclerView.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, RecyclerViewFragment())
                .addToBackStack(BackstackLogin)
                .commit()
        }

        toTheRegistration.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, RegistrationFragment())
                .addToBackStack(BackstackLogin)
                .commit()
        }

        val editText = view.findViewById<TextInputEditText>(R.id.et_text)
        val editText2 = view.findViewById<TextInputEditText>(R.id.et_text2)


        toTheMainScreen.setOnClickListener{

            if(editText.text.toString().isEmpty()){
                editText.error = ErrorFieldUsername

            }else if(editText2.text.toString().isEmpty()){
                editText2.error = ErrorFieldPassword
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

