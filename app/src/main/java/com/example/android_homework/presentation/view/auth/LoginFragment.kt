package com.example.android_homework.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android_homework.App
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentLoginBinding
import com.example.android_homework.utils.NavHelper.navigate
import com.example.android_homework.utils.NavHelper.setGraph
import javax.inject.Inject

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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

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
        setGraph(R.navigation.main_graph)
    }

    override fun goToRecyclerView() {
        navigate(R.id.action_loginFragment_to_itemsFragment)
    }

    override fun buttonPushResult(buttonPush: Boolean) {
        when(buttonPush){
             true ->
                 Toast.makeText(requireContext(), getString(R.string.seen_screen), Toast.LENGTH_SHORT).show()
            false ->
                navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }
}

