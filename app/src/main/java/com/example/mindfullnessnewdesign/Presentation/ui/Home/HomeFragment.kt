package com.example.mindfullnessnewdesign.Presentation.ui.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.Presentation.adapters.GenericAdapter
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.DailyExercisesLayoutBinding
import com.example.mindfullnessnewdesign.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
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
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        setUpDailyExercises(meditationList)
    }

    private fun setUpDailyExercises(list: List<MeditationItem>) {

        mAdapter = GenericAdapter()
        recyclerView = binding.dailyExercisesPager
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = mAdapter
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(context).apply { LinearLayoutManager.HORIZONTAL }
//            adapter = mAdapter
//        }

        mAdapter.listOfItems = list

        mAdapter.expressionOnCreateViewHolder = { viewGroup ->
            DailyExercisesLayoutBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        }

        mAdapter.expressionViewHolderBinding = { item, viewBinding ->
            val view = viewBinding as DailyExercisesLayoutBinding

            // Bind data to views
            view.title.text = item.meditationTitle
            view.descriptionText.text = item.meditationDescription
            view.topImage.setImageResource(item.meditationImage)
        }

    }
}