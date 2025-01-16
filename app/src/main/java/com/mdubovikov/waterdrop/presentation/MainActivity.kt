package com.mdubovikov.waterdrop.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mdubovikov.waterdrop.R
import com.mdubovikov.waterdrop.WaterDropApp
import com.mdubovikov.waterdrop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding ?: throw IllegalStateException("Activity $this binding cannot be accessed")

    private val component by lazy {
        (application as WaterDropApp).applicationComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setupNavigation()
    }

    private fun setupNavigation() {
        val navView: BottomNavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}