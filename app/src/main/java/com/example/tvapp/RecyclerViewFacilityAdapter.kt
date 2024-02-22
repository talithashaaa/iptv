package com.example.tvapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFacilityAdapter constructor(private val getActivity: FacilityFragment, private val facilityList : List<Facility>) :
RecyclerView.Adapter<RecyclerViewFacilityAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_facility, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return facilityList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.rvfacilitytitle.text = facilityList[position].title
        holder.rvfacilityimg.setImageResource(facilityList[position].image)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvfacilitytitle : TextView = itemView.findViewById(R.id.rvfacilitytitle)
        val rvfacilityimg : ImageView = itemView.findViewById(R.id.rvfacilityimg)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }


}