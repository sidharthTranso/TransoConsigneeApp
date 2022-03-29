package com.example.consigneetransoapp.view.VehicleList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.consigneetransoapp.view.VehicleList.completed.CompletedBookingFragment
import com.example.consigneetransoapp.view.VehicleList.ongoing.OngoingBookingsFragment

private const val NUM_TABS = 2
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return OngoingBookingsFragment()
            1 -> return CompletedBookingFragment()
        }
        return OngoingBookingsFragment()
    }
}