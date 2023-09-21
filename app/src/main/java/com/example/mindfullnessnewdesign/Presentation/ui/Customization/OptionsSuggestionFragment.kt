package com.example.mindfullnessnewdesign.Presentation.ui.Customization

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.Presentation.adapters.MeditationItemAdapter
import com.example.mindfullnessnewdesign.Presentation.ui.Home.HomeActivity
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.FragmentOptionsSuggestionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OptionsSuggestionFragment : Fragment(R.layout.fragment_options_suggestion) {

    private lateinit var adapter : MeditationItemAdapter
    private lateinit var recyclerView : RecyclerView

    private lateinit var binding: FragmentOptionsSuggestionBinding

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

        binding = FragmentOptionsSuggestionBinding.bind(view)

        initializeAdapter(meditationList)

        binding.btnGetStarted.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeAdapter(list: List<MeditationItem>) {
        adapter = MeditationItemAdapter(list)
        recyclerView = binding.meditationCardRv
        recyclerView.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setOnItemClickListener(object : MeditationItemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
               //TO BE IMPLEMENTED
            }
        })

        recyclerView.adapter = adapter
    }

}