package com.example.consigneetransoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.consigneetransoapp.R
import com.example.consigneetransoapp.databinding.ActivityParentBinding

class ParentActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityParentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        _binding = DataBindingUtil.setContentView(this,R.layout.activity_parent)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.login_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

    }
}