package com.example.mindfullnessnewdesign.Presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.mindfullnessnewdesign.R

class OnBoardingAdapter(var context: Context): PagerAdapter() {
    private val layoutInflater: LayoutInflater

    private val splashscreenDescriptions = arrayOfNulls<String>(3)
    private val splashscreenimages = intArrayOf(
        R.drawable.butterflies, R.drawable.floral_2,
        R.drawable.floral_3
    )

    private val onboardingTitles = arrayListOf(
        R.string.mindfullness_meditation, R.string.mindfullness, R.string.meditation
    )

    private val onboardingDescriptions = arrayListOf(
        R.string.mindfullness_description, R.string.mindfullness_description_2, R.string.mindfullness_description_3
    )
    init {
        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // // Returns the number of pages/items to be displayed in the ViewPager.
    override fun getCount(): Int {
        return splashscreenimages.size

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.layout_onboard, container, false)

        val imgSplashScreen: ImageView
        val onboardingTitle: TextView
        val onboardingDescription: TextView

        imgSplashScreen = view.findViewById(R.id.onboarding_image)
        onboardingTitle = view.findViewById(R.id.card_title)
        onboardingDescription = view.findViewById(R.id.card_description)
//        tvSplashScreenDescri=view.findViewById(R.id.tv_slider_descr)

        //   tvSplashScreenDescri.text=splashscreenDescriptions[position]

        imgSplashScreen.setImageResource(splashscreenimages[position])
        onboardingTitle.setText(onboardingTitles[position])
        onboardingDescription.setText(onboardingDescriptions[position])

        container.addView(view)

        return view

    }
    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as ConstraintLayout)
    }

}