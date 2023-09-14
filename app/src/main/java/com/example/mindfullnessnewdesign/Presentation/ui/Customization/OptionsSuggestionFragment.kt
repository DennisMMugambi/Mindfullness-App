package com.example.mindfullnessnewdesign.Presentation.ui.Customization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentOptionsSelectionBinding

class OptionsSuggestionFragment : Fragment(R.layout.fragment_options_suggestion) {

    private lateinit var binding: FragmentOptionsSelectionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOptionsSelectionBinding.bind(view)
    }

}