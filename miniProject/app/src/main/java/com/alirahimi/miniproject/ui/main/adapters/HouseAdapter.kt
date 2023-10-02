package com.alirahimi.miniproject.ui.main.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.miniproject.R
import com.alirahimi.miniproject.ui.detail.DetailActivity
import com.alirahimi.miniproject.ui.main.models.HouseModel
import com.alirahimi.miniproject.util.BUNDLE_ADDRESS
import com.alirahimi.miniproject.util.BUNDLE_IMAGE
import com.alirahimi.miniproject.util.BUNDLE_PRICE

class HouseAdapter constructor(private val items: MutableList<HouseModel>) :
    RecyclerView.Adapter<HouseAdapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return ViewHolder(inflater.inflate(R.layout.row_house_list, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.housesRow_image)
        private val price = itemView.findViewById<TextView>(R.id.housesRow_price)
        private val address = itemView.findViewById<TextView>(R.id.housesRow_address)
        private val info = itemView.findViewById<TextView>(R.id.housesRow_info)

        @SuppressLint("SetTextI18n")
        fun bind(item: HouseModel) {
            image.setImageResource(item.image)
            price.text = item.price
            address.text = item.address
            info.text = "${item.bedroom} bedrooms / ${item.bathroom} bathrooms / ${item.area} ft^2"

            itemView.setOnClickListener {
                Intent(context, DetailActivity::class.java).apply {
                    this.putExtra(BUNDLE_IMAGE, item.image)
                    this.putExtra(BUNDLE_PRICE, item.price)
                    this.putExtra(BUNDLE_ADDRESS, item.address)
                    context.startActivity(this)
                }
            }
        }
    }
}