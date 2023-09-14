package com.example.mindfullnessnewdesign.Presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfullnessnewdesign.Domain.Models.MeditationItem
import com.example.mindfullnessnewdesign.R

class MeditationItemAdapter(private var itemList: List<MeditationItem>?) : RecyclerView.Adapter<MeditationItemAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var clickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val meditationImageView : ImageView = itemView.findViewById(R.id.meditation_image)
        private val meditationTitle : TextView = itemView.findViewById(R.id.meditation_title)
        private val meditationDescription : TextView = itemView.findViewById(R.id.meditation_description)
        private val meditationCourse : TextView = itemView.findViewById(R.id.tv_course)
        private val meditationDuration : TextView = itemView.findViewById(R.id.tv_duration)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    clickListener?.onItemClick(position)
                }
            }
        }


        fun bind(item: MeditationItem) {
            meditationImageView.setImageResource(item.meditationImage)
            meditationTitle.text = item.meditationTitle
            meditationDescription.text = item.meditationDescription
            meditationCourse.text = item.meditationCourse
            meditationDuration.text = item.meditationDuration
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.meditation_item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MeditationItemAdapter.ViewHolder, position: Int) {
        val item = itemList?.get(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList?.size!!
    }

    fun updateList(newList: List<MeditationItem>) {
        val diffResult = itemList?.let { MeditationAdapterDiffCallback(it, newList) }
            ?.let { DiffUtil.calculateDiff(it) }
        itemList = newList
        if (diffResult != null) {
            diffResult.dispatchUpdatesTo(this)
        }
    }

}

class MeditationAdapterDiffCallback(private val oldList: List<MeditationItem>, private val newList: List<MeditationItem>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].meditationTitle == newList[newItemPosition].meditationTitle
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.meditationTitle == newItem.meditationTitle
    }
}