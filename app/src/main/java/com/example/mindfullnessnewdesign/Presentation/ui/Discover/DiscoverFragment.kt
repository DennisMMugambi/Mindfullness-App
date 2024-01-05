package com.example.mindfullnessnewdesign.Presentation.ui.Discover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.Presentation.adapters.GenericAdapter
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.DailyExercisesLayoutBinding
import com.example.mindfullnessnewdesign.databinding.FragmentDiscoverBinding
import com.example.mindfullnessnewdesign.databinding.MeditationItemLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverFragment : Fragment(R.layout.fragment_discover) {

    private lateinit var binding: FragmentDiscoverBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: GenericAdapter<MeditationItem>

    val meditationList = listOf(
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        ),
        MeditationItem(
            meditationImage = R.drawable.floral_2, // Replace with the actual image resource ID
            meditationTitle = "Basic",
            meditationDescription = "Learn the fundamentals of meditation",
            meditationCourse = "Beginner's Guide",
            meditationDuration = "15 minutes"
        )
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDiscoverBinding.bind(view)
        setUpRecommendedExercises(meditationList)
    }

    private fun setUpRecommendedExercises(list: List<MeditationItem>) {

        mAdapter = GenericAdapter()
        recyclerView = binding.dailyExercisesPager
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = mAdapter

        mAdapter.listOfItems = list

        mAdapter.expressionOnCreateViewHolder = { viewGroup ->
            MeditationItemLayoutBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        }

        mAdapter.expressionViewHolderBinding = { item, viewBinding ->
            val view = viewBinding as MeditationItemLayoutBinding

            // Bind data to views
            view.meditationTitle.text = item.meditationTitle
            view.meditationDescription.text = item.meditationDescription
            view.meditationImage.setImageResource(item.meditationImage)
        }

    }
}