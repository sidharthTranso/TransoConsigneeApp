package com.example.consigneetransoapp.view.VehicleList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.consigneetransoapp.R
import com.example.consigneetransoapp.databinding.VehicleListFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class VehicleListFragment : Fragment() {
    private lateinit var vehicleListFragmentBinding: VehicleListFragmentBinding


    private lateinit var viewModel: VehicleListViewModel

    val vehicleArray = arrayOf(
        "Incoming Trips",
        "Completed Trips",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vehicleListFragmentBinding = VehicleListFragmentBinding.inflate(inflater)

        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        vehicleListFragmentBinding.viewPagerVehicle.adapter = adapter



        TabLayoutMediator(vehicleListFragmentBinding.tabs,vehicleListFragmentBinding.viewPagerVehicle){ tab,position ->
            tab.text = vehicleArray[position]

        }.attach()

        return vehicleListFragmentBinding.root
    }

}