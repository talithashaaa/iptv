package com.example.tvapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewServiceAdapter(private val getActivity: RoomServiceDetail, private val serviceList : List<ServicesData>) :
RecyclerView.Adapter<RecyclerViewServiceAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_things, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val service = serviceList[position]

//        holder.rvservicetxt.text = serviceList[position].service_name
        holder.rvservicetxt.text = service.service_name
        Glide.with(holder.itemView.context)
            .load(service.service_image)
            .into(holder.rvserviceimg)    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvservicetxt : TextView = itemView.findViewById(R.id.rvservicetxt)
        val rvserviceimg : ImageView = itemView.findViewById(R.id.rvserviceimg)
    }


}