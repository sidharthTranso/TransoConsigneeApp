package com.example.consigneetransoapp.view.VehicleList.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.consigneetransoapp.MapsActivity
import com.example.consigneetransoapp.R
import com.google.android.material.card.MaterialCardView

class VehicleListAdapter :
    RecyclerView.Adapter<VehicleListAdapter.InternshipViewHolder>() {

//    private var internshipList = emptyList<Internship>()
//    var onItemClick: ((Internship) -> Unit)? = null

//    internal fun setInternshipList(internshipList: List<Internship>) {
//        this.internshipList = internshipList
//        notifyDataSetChanged()
//    }

    inner class InternshipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var projectName: TextView = itemView.findViewById(R.id.eachInternshipProjectNameTv)
//        var projectDetails: TextView = itemView.findViewById(R.id.eachInternshipProjectDetailsTv)
//        var university: TextView = itemView.findViewById(R.id.eachInternshipUniversityTv)

        init {
            itemView.setOnClickListener {

                //onItemClick?.invoke(internshipList[adapterPosition])
            }
        }
    }
    private fun goToMain(){

    }

    private lateinit var materialCardView: MaterialCardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InternshipViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_order , parent , false)
        materialCardView = view.findViewById(R.id.eachOrder)
        materialCardView.setOnClickListener {
            val intent = Intent(parent.context , MapsActivity::class.java)
            parent.context.startActivity(intent)
        }
        return InternshipViewHolder(view)
    }

    override fun onBindViewHolder(holder: InternshipViewHolder, position: Int) {
       // Log.d("TAG", "onBindViewHolder: "+internshipList)


    }

    override fun getItemCount(): Int {
        return 10
    }

}