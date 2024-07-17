package com.example.mindfullnessnewdesign.Presentation.ui.Auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentCurrentFeelingBinding
import com.example.mindfullnessnewdesign.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.login_to_optionsSelection)
        }

        binding.signUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_signUp)
        }
    }
}