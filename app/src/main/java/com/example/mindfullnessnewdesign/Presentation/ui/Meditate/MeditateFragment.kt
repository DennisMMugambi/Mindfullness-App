package com.example.mindfullnessnewdesign.Presentation.ui.Meditate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentMeditateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeditateFragment : Fragment(R.layout.fragment_meditate) {

    private lateinit var binding: FragmentMeditateBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMeditateBinding.bind(view)
    }
}