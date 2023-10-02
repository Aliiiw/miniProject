package com.alirahimi.miniproject.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.miniproject.R
import com.alirahimi.miniproject.ui.main.adapters.FilterAdapter
import com.alirahimi.miniproject.ui.main.adapters.HouseAdapter
import com.alirahimi.miniproject.ui.main.models.HouseModel

class MainActivity : AppCompatActivity() {


    private val filterList: MutableList<String> = mutableListOf()
    private val houseList: MutableList<HouseModel> = mutableListOf()
    private lateinit var filterAdapter: FilterAdapter
    private lateinit var houseAdapter: HouseAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Filters
        makeDumbFilters()
        filterAdapter = FilterAdapter(filterList)
        val filterRecyclerView = findViewById<RecyclerView>(R.id.filterRecyclerView)
        filterRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        filterRecyclerView.adapter = filterAdapter

        //Houses
        makeDumbHouses()
        houseAdapter = HouseAdapter(houseList)
        val houseRecyclerView = findViewById<RecyclerView>(R.id.houseRecyclerView)
        houseRecyclerView.layoutManager = LinearLayoutManager(this)
        houseRecyclerView.adapter = houseAdapter

    }

    private fun makeDumbFilters() {
        filterList.add("< $220.000")
        filterList.add("For Sale")
        filterList.add("With Garage")
        filterList.add("With Elevator")
        filterList.add("Has Pool")
        filterList.add("More than 4 beds")
    }

    private fun makeDumbHouses() {
        houseList.add(
            HouseModel(
                R.drawable.house1,
                "$200.000",
                "Jenison, Ml 49428, SF",
                4,
                2,
                1.416f
            )
        )
        houseList.add(
            HouseModel(
                R.drawable.house2,
                "$140.000",
                "351 Rockwood Dr, SF",
                2,
                1,
                0.580f
            )
        )
        houseList.add(HouseModel(R.drawable.house3, "$500.000", "214 JakeNorton, EF", 5, 3, 2.632f))
        houseList.add(HouseModel(R.drawable.house4, "$290.000", "DrKeyOk 2549, SF", 3, 2, 1.967f))
        houseList.add(
            HouseModel(
                R.drawable.house5,
                "$350.000",
                "Lambers, Ml 500, EF",
                2,
                2,
                2.240f
            )
        )
    }
}