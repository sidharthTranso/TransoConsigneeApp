package com.example.consigneetransoapp.view.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.consigneetransoapp.R
import com.example.consigneetransoapp.databinding.LoginFragmentBinding
import com.example.consigneetransoapp.databinding.OtpFragmentBinding

class OtpFragment : Fragment() {

    private lateinit var otpFragmentBinding: OtpFragmentBinding
    private lateinit var viewModel: OtpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        otpFragmentBinding = OtpFragmentBinding.inflate(inflater)
        otpFragmentBinding.otpSubmit.setOnClickListener {
            val action =    OtpFragmentDirections.actionOtpFragmentToVehicleListFragment()
            Navigation.findNavController(otpFragmentBinding.otpSubmit).navigate(action)
        }
        return otpFragmentBinding.root
    }



}