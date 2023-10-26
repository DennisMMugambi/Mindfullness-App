package com.example.mindfullnessnewdesign.Presentation.ui.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.Presentation.adapters.DailyExercisesAdapter
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding : FragmentProfileBinding

    val meditationList = listOf(
        MeditationItem(
            meditationImage = R.drawable.mind_onboard_1, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        )
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileBinding.bind(view)
    }

    private fun setUpDailyExercises(){
//        binding.dailyExercisesPager.apply {
//            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//            adapter = DailyExercisesAdapter
//        }
    }
}