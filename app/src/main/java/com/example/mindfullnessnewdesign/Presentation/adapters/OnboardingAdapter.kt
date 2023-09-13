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

    private val splashscreenimages = intArrayOf(
        R.drawable.butterflies, R.drawable.floral_2,
        R.drawable.floral_4
    )

    init {
        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return splashscreenimages.size

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.layout_onboard, container, false)

        val imgSplashScreen: ImageView

        imgSplashScreen = view.findViewById(R.id.onboarding_image)
        imgSplashScreen.setImageResource(splashscreenimages[position])

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