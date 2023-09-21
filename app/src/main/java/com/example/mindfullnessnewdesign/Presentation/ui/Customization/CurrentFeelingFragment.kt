package com.example.mindfullnessnewdesign.Presentation.ui.Customization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentCurrentFeelingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentFeelingFragment : Fragment(R.layout.fragment_current_feeling) {

    private lateinit var binding: FragmentCurrentFeelingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCurrentFeelingBinding.bind(view)

        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_moodToday_to_meditationSuggestion)
        }
    }

}