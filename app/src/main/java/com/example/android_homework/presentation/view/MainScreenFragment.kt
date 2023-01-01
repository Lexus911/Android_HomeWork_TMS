package com.example.android_homework.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.android_homework.R
import com.example.android_homework.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment() {
    private var _viewBinding: FragmentMainScreenBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMainScreenBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, NestedFragment())
            .commit()

        viewModel.showDialog()

    viewModel.dialog.observe(viewLifecycleOwner) {

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.congratulations) + " ${it.userName} ${it.userPassword}" )
            .setMessage(getString(R.string.welcome))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                Toast.makeText(requireContext(), getString(R.string.calle_ok), Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
        dialog.show()
    }
    }
}