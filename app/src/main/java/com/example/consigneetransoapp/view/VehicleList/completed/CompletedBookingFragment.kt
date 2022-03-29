package com.example.consigneetransoapp.view.VehicleList.completed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consigneetransoapp.R
import com.example.consigneetransoapp.databinding.CompletedBookingFragmentBinding
import com.example.consigneetransoapp.databinding.LoginFragmentBinding
import com.example.consigneetransoapp.view.VehicleList.adapter.VehicleListAdapter

class CompletedBookingFragment : Fragment() {

    private lateinit var completedBookingFragmentBinding: CompletedBookingFragmentBinding
    private val adapter = VehicleListAdapter()
    private lateinit var viewModel: CompletedBookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        completedBookingFragmentBinding = CompletedBookingFragmentBinding.inflate(inflater)
        completedBookingFragmentBinding.completedRV.setHasFixedSize(true)
        completedBookingFragmentBinding.completedRV.layoutManager = LinearLayoutManager(context)

        completedBookingFragmentBinding.completedRV.adapter = adapter

        return completedBookingFragmentBinding.root
    }



}