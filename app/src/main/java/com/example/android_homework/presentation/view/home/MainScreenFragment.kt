package com.example.android_homework.presentation.view.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.android_homework.App
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentMainScreenBinding
import com.example.android_homework.presentation.model.UsersModel
import com.example.android_homework.utils.NavHelper.setGraph
import javax.inject.Inject


class MainScreenFragment : Fragment(), MainScreenView {
    private var _viewBinding: FragmentMainScreenBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var mainScreenPresenter: MainScreenPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMainScreenBinding.inflate(inflater)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        mainScreenPresenter.setView(this)

        mainScreenPresenter.showUserName()

        viewBinding.btnBackToLogin.setOnClickListener {
            mainScreenPresenter.backToLogin()
        }

        val  dialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(getString(R.string.welcome))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.ok)){ _, _ ->
                Toast.makeText(requireContext(), getString(R.string.calle_ok), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.cancel)){ dialog, _ ->
                dialog.cancel()
            }
        dialog.show()
    }


    @SuppressLint("SetTextI18n")
    override fun getUserName(userName: String, userPassword: String) {
        viewBinding.tvMainscreen.text = "${userName}\n${userPassword}"
    }

    override fun getUsersData(usersData: List<UsersModel>) {
        viewBinding.tvMainscreenReg.text = "$usersData"
    }

    override fun backToLogin() {
        setGraph(R.navigation.auth_graph)
    }


}