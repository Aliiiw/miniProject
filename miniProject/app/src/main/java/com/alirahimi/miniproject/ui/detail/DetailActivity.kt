package com.alirahimi.miniproject.ui.detail

import com.alirahimi.miniproject.ui.detail.adapter.HouseInfoAdapter
import com.alirahimi.miniproject.ui.detail.model.HouseInfo
import com.alirahimi.miniproject.util.BUNDLE_ADDRESS
import com.alirahimi.miniproject.util.BUNDLE_IMAGE
import com.alirahimi.miniproject.util.BUNDLE_PRICE
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.miniproject.R

class DetailActivity : AppCompatActivity() {

    //Bundle
    private lateinit var bundle: Bundle

    //Other
    private val housesInfoList: MutableList<HouseInfo> = mutableListOf()
    private lateinit var houseInfoAdapter: HouseInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //Initialize
        bundle = intent.extras!!
        val detailPageHeaderImg = findViewById<ImageView>(R.id.detailPageHeaderImg)
        val detailPagePriceTxt = findViewById<TextView>(R.id.detailPagePriceTxt)
        val detailPageAddressTxt = findViewById<TextView>(R.id.detailPageAddressTxt)
        //Set data
        bundle.let {
            detailPageHeaderImg.setImageResource(it.getInt(BUNDLE_IMAGE))
            detailPagePriceTxt.text = it.getString(BUNDLE_PRICE)
            detailPageAddressTxt.text = it.getString(BUNDLE_ADDRESS)
        }
        //House info
        addHouseInfo()
        val detailPageHouseInfoList = findViewById<RecyclerView>(R.id.detailPageHouseInfoList)

        houseInfoAdapter = HouseInfoAdapter(housesInfoList)
        detailPageHouseInfoList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detailPageHouseInfoList.adapter = houseInfoAdapter
        //Back
        val detailPageHeaderBackImg = findViewById<ImageView>(R.id.detailPageHeaderBackImg)
        detailPageHeaderBackImg.setOnClickListener { onBackPressed() }
    }

    private fun addHouseInfo() {
        housesInfoList.add(HouseInfo(500, "Square foot"))
        housesInfoList.add(HouseInfo(4, "Bedrooms"))
        housesInfoList.add(HouseInfo(2, "Bathrooms"))
        housesInfoList.add(HouseInfo(1, "Toilet"))
        housesInfoList.add(HouseInfo(2, "Garage"))
        housesInfoList.add(HouseInfo(1, "Elevator"))
    }
}