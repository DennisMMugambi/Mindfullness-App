package com.example.mindfullnessnewdesign.Presentation.ui.Customization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentOptionsSelectionBinding

class OptionsSelectionFragment : Fragment(R.layout.fragment_options_selection) {

    private lateinit var binding: FragmentOptionsSelectionBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOptionsSelectionBinding.bind(view)

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_options_to_moodToday)
        }
    }
}