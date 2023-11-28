package com.example.mindfullnessnewdesign.Presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class GenericAdapter<T>: RecyclerView.Adapter<GenericAdapter<T>.BaseViewHolder<T>>(){

    var listOfItems: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var clickListener: OnItemClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        clickListener = listener
    }

    var expressionViewHolderBinding: ((T, ViewBinding) -> Unit)? = null
    var expressionOnCreateViewHolder: ((ViewGroup)->ViewBinding)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return expressionOnCreateViewHolder?.let { it(parent) }?.let { BaseViewHolder(it, expressionViewHolderBinding!!)} !!
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(listOfItems[position])
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    inner class BaseViewHolder<T> internal constructor(private val binding: ViewBinding, private val expression:(T, ViewBinding) -> Unit)
        :RecyclerView.ViewHolder(binding.root) {

            fun bind(item: T){
                expression(item, binding)
            }

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    clickListener?.onItemClick(position)
                }
            }
        }
        }
}