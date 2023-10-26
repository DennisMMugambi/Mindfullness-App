package com.example.mindfullnessnewdesign.Presentation.adapters

import android.content.Context
import android.media.browse.MediaBrowser.MediaItem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.R

class DailyExercisesAdapter(var context: Context, private var items: List<MeditationItem>): PagerAdapter() {
    private val layoutInflater: LayoutInflater
    private val exerciseList = items
    init {
        layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    // // Returns the number of pages/items to be displayed in the ViewPager.
    override fun getCount(): Int {
        return exerciseList.size

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = layoutInflater.inflate(R.layout.daily_exercises_layout, container, false)

        val imgSplashScreen: ImageView = view.findViewById(R.id.meditation_image)
        imgSplashScreen.setImageResource(exerciseList[position].meditationImage)

        val title: TextView = view.findViewById<TextView?>(R.id.meditation_title)
        title.text = exerciseList[position].meditationTitle

        val description: TextView = view.findViewById(R.id.meditation_description)
        description.text = exerciseList[position].meditationDescription

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