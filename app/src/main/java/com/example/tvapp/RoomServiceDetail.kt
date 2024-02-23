package com.example.tvapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

class RoomServiceDetail : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var recyclerViewServiceAdapter: RecyclerViewServiceAdapter? = null
    private var serviceList: MutableList<ServicesData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_service_detail)
        supportActionBar?.hide()

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"))
        val dateFormat = DateFormat.getDateInstance().format(calendar.time)

        val dateTextView = findViewById<TextView>(R.id.text_date)
        dateTextView.text = dateFormat

        val dayFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        val dayTextView = findViewById<TextView>(R.id.text_day)
        val dayOfWeek = dayFormat.format(calendar.time)
        dayTextView.text = dayOfWeek




        serviceList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvthings) as RecyclerView
        recyclerViewServiceAdapter = RecyclerViewServiceAdapter(this, serviceList)
        val numberOfColumns = 1
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, numberOfColumns, LinearLayoutManager.HORIZONTAL, false)

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewServiceAdapter

        prepareFacilityListData()
    }

    private fun prepareFacilityListData() {
        var service = ServicesData(R.drawable.bar, "Towel")
        serviceList.add(service)

        service = ServicesData(R.drawable.bar, "Towel")
        serviceList.add(service)

        service = ServicesData(R.drawable.bar, "Towel")
        serviceList.add(service)

        service = ServicesData(R.drawable.bar, "Towel")
        serviceList.add(service)

        recyclerViewServiceAdapter?.notifyDataSetChanged()


    }

    }