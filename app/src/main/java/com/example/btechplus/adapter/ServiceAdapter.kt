package com.example.btechplus.adapter

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.btechplus.R
import com.example.btechplus.model.Service

class ServiceAdapter(
    private val serviceList: List<Service>,
    private val onItemClick: (Service) -> Unit
) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val serviceName: TextView = view.findViewById(R.id.tvServiceName)
        val serviceDescription: TextView = view.findViewById(R.id.tvServiceDescription)
        val imageView: ImageView = itemView.findViewById(R.id.serviceImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = serviceList[position]
        holder.serviceName.text = service.name
        holder.serviceDescription.text = service.description
        holder.imageView.setImageResource(service.imageResId)
        holder.itemView.setOnClickListener { onItemClick(service) }
    }

    override fun getItemCount() = serviceList.size
}

