package com.example.android_homework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentLoginBinding
import com.example.android_homework.presentation.view.home.ItemsFragment
import com.example.android_homework.presentation.view.home.MainScreenFragment

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


const val BackstackLogin = "login_screen"

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        viewBinding.btnRecyclerView.setOnClickListener{
            loginPresenter.goToRecyclerView()
        }

        viewBinding.btnRegistration.setOnClickListener{
            loginPresenter.goToRegistration()
        }

        viewBinding.btnLogin.setOnClickListener{

            if(viewBinding.etText.text.toString().isEmpty()){
                viewBinding.etText.error = getString(R.string.error_field_username)

            }else if(viewBinding.etText2.text.toString().isEmpty()){
                viewBinding.etText2.error = getString(R.string.error_field_password)
            }
            else {
                loginPresenter.loginUser(
                viewBinding.etText.text.toString(),
                viewBinding.etText2.text.toString())
            }
        }
    }

    override fun userLoggedIn() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, MainScreenFragment())
            .commit()
    }

    override fun goToRecyclerView() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, ItemsFragment())
            .addToBackStack(BackstackLogin)
            .commit()
    }

    override fun buttonPushResult(buttonPush: Boolean) {
        when(buttonPush){
             true ->
                 Toast.makeText(requireContext(), getString(R.string.seen_screen), Toast.LENGTH_SHORT).show()
            false ->{
                parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, RegistrationFragment())
                .addToBackStack(BackstackLogin)
                .commit()}
        }
    }
}

