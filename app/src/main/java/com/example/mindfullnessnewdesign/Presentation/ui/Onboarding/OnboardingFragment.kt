package com.example.mindfullnessnewdesign.Presentation.ui.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.mindfullnessnewdesign.Presentation.adapters.OnBoardingAdapter
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.Utils.AutoSlideAdvertisement
import com.example.mindfullnessnewdesign.databinding.FragmentOnboardingBinding


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
        binding.pager.adapter = onBoardingAdapter
        //binding.tDots.setupWithViewPager(binding.pager, true)
        onBoardingAdapter.notifyDataSetChanged()

        //binding.tvSliderTitle.setText(R.string.onboarding_title_one)
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
//                        binding.tvSliderDescr.setText(R.string.screen_1_description)
//                        binding.tvSliderTitle.setText(R.string.onboarding_title_one)
//                        binding.btnGetStarted.setText(R.string.next)
                    }
                    1 -> {
//                        binding.tvSliderDescr.setText(R.string.screen_2_description)
//                        binding.tvSliderTitle.setText(R.string.onboarding_title_two)
//                        binding.btnGetStarted.setText(R.string.next)
                    }
                    2-> {
//                        binding.tvSliderDescr.setText(R.string.screen_3_description)
//                        binding.tvSliderTitle.setText(R.string.onboarding_title_three)
//                        binding.btnGetStarted.setText(R.string.get_started)
                    }
                    else -> {
                        // binding.tvSliderDescr.setText(R.string.screen_1_description)
                        // binding.tvSliderTitle.setText(R.string.onboarding_title_one)
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
      //  binding.btnGetStarted.setOnClickListener {
            when(binding.pager.currentItem) {
                0 -> { binding.pager.currentItem += 1}
                1 -> { binding.pager.currentItem += 1}
                2 -> { isLastScreen = true}
            }

            if (isLastScreen) {
              //  binding.loading.visibility = View.VISIBLE
                // showAuthModule()
               // findNavController().navigate(R.id.action_onboardingFragment_to_loginFragment)
            }
      //  }

//        binding.skipBtn.setOnClickListener {
//            binding.pager.currentItem = 2
//            // binding.btnGetStarted.setText(R.string.get_started)
//        }
    }

}