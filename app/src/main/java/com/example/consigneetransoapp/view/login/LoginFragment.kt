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

class LoginFragment : Fragment() {

    private lateinit var loginFragmentBinding: LoginFragmentBinding

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater)

        loginFragmentBinding.loginSignIN.setOnClickListener {
            val action =    LoginFragmentDirections.actionLoginFragmentToOtpFragment()
            Navigation.findNavController(loginFragmentBinding.loginSignIN).navigate(action)
        }
        return loginFragmentBinding.root
    }


}