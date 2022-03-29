package com.example.consigneetransoapp.view.VehicleList.ongoing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consigneetransoapp.R
import com.example.consigneetransoapp.databinding.CompletedBookingFragmentBinding
import com.example.consigneetransoapp.databinding.OngoingBookingsFragmentBinding
import com.example.consigneetransoapp.view.VehicleList.adapter.VehicleListAdapter

class OngoingBookingsFragment : Fragment() {
    private lateinit var ongoingBookingsFragmentBinding: OngoingBookingsFragmentBinding

    private val adapter = VehicleListAdapter()
    private lateinit var viewModel: OngoingBookingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ongoingBookingsFragmentBinding = OngoingBookingsFragmentBinding.inflate(inflater)
        ongoingBookingsFragmentBinding.ongoingRV.setHasFixedSize(true)
        ongoingBookingsFragmentBinding.ongoingRV.layoutManager = LinearLayoutManager(context)

        ongoingBookingsFragmentBinding.ongoingRV.adapter = adapter

        return ongoingBookingsFragmentBinding.root
    }



}