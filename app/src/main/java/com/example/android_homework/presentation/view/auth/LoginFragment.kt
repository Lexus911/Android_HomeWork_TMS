package com.example.android_homework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentLoginBinding
import com.example.android_homework.presentation.view.home.ItemsPresenter
import com.example.android_homework.presentation.view.home.MainScreenFragment
import com.example.android_homework.presentation.view.home.RecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


const val BackstackLogin = "login_screen"

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var authPresenter: AuthPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnRecyclerView.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, RecyclerViewFragment())
                .addToBackStack(BackstackLogin)
                .commit()
        }

        viewBinding.btnRegistration.setOnClickListener{
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, RegistrationFragment())
                .addToBackStack(BackstackLogin)
                .commit()
        }

        viewBinding.btnLogin.setOnClickListener{

            if(viewBinding.etText.text.toString().isEmpty()){
                viewBinding.etText.error = getString(R.string.error_field_username)

            }else if(viewBinding.etText2.text.toString().isEmpty()){
                viewBinding.etText2.error = getString(R.string.error_field_password)
            }
            else {
                authPresenter.loginUser(
                viewBinding.etText.text.toString(),
                viewBinding.etText2.text.toString())

                parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, MainScreenFragment())
                .commit()
            }
        }
    }
}

