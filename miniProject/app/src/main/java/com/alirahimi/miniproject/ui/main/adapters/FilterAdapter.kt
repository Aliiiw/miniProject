package com.alirahimi.miniproject.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.miniproject.R

class FilterAdapter constructor(private val items: MutableList<String>) :
    RecyclerView.Adapter<FilterAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.row_filter_list, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val info = itemView.findViewById<TextView>(R.id.filterTextView_text)

        fun bind(item: String) {
            info.text = item
        }
    }
}