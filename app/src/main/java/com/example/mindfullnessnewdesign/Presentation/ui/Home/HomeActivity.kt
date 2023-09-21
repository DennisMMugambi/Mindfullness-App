package com.example.mindfullnessnewdesign.Presentation.ui.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mindfullnessnewdesign.R
import com.example.mindfullnessnewdesign.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var parentView : ConstraintLayout
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //create bottom navigation view object
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Handle destination change and update ActionBar accordingly
            if ((destination.id == R.id.home || destination.id == R.id.meditate) || (destination.id == R.id.profile || destination.id == R.id.discover)) {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }

        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.id  == R.id.home) {
            //showLogoutConfirmationDialog()
        } else {
            navController.navigateUp()
        }
    }
}