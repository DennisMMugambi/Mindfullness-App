package com.example.mindfullnessnewdesign.Presentation.ui.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.mindfullnessnewdesign.Presentation.adapters.OnBoardingAdapter
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.Utils.AutoSlideAdvertisement
import com.example.mindfullnessnewdesign.databinding.FragmentOnboardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private lateinit var binding : FragmentOnboardingBinding

    private lateinit var parentView : ConstraintLayout
    private var isLastScreen = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingBinding.bind(view)

        loadSliders()
    }

    private fun loadSliders(){
        val onBoardingAdapter = OnBoardingAdapter(requireContext())
        val springDotsIndicator = binding.tDots
        val viewPager = binding.pager
        viewPager.adapter = onBoardingAdapter
        springDotsIndicator.setupWithViewPager(viewPager, true)
        onBoardingAdapter.notifyDataSetChanged()

        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    0 -> {
                        binding.cardTitle.setText(R.string.mindfullness_meditation)
                        binding.cardDescription.setText(R.string.mindfullness_description)
                        binding.btnGetStarted.setText(R.string.next)
                    }
                    1 -> {
                        binding.cardTitle.setText(R.string.mindfullness)
                        binding.cardDescription.setText(R.string.mindfullness_description_2)
                        binding.btnGetStarted.setText(R.string.next)
                    }
                    2-> {
                        binding.cardTitle.setText(R.string.meditation)
                        binding.cardDescription.setText(R.string.mindfullness_description_3)
                        binding.btnGetStarted.setText(R.string.get_started)
                    }
                    else -> {
                         binding.cardTitle.setText(R.string.mindfullness_meditation)
                         binding.cardDescription.setText(R.string.mindfullness_description)
                    }
                }
            }

            override fun onPageSelected(position: Int) {



            }
        })

        scrollToNext()
        val autoPlay = AutoSlideAdvertisement()
        autoPlay.autoPlayAdvertisement(binding.pager)

    }

    private fun scrollToNext() {
        binding.btnGetStarted.setOnClickListener {
            when(binding.pager.currentItem) {
                0 -> { binding.pager.currentItem += 1}
                1 -> { binding.pager.currentItem += 1}
                2 -> { isLastScreen = true}
            }

            if (isLastScreen) {
                findNavController().navigate(R.id.action_onboarding_to_optionsSelection)
            }
        }

        binding.btnSkip.setOnClickListener {
            binding.pager.currentItem = 2
            binding.btnGetStarted.setText(R.string.get_started)
        }
    }

}