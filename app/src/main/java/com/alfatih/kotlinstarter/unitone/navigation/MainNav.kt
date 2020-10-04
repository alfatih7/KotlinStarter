package com.alfatih.kotlinstarter.unitone.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.alfatih.kotlinstarter.R
import com.alfatih.kotlinstarter.databinding.ActivityMainNavBinding

class MainNav : AppCompatActivity() {
    private lateinit var binding: ActivityMainNavBinding

    //add the lateinit drawerLayout member variable to represent the drawer layout
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_nav)

        drawerLayout = binding.drawerLayout
        //find the navigation controller object
        val navController = this.findNavController(R.id.nav_host_fragment)
        // 1. link the navigation controller to the app bar

        // 2. in nav drawer Add the drawerLayout as
        // the third parameter to the setupActionBarWithNavController() method
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        //to display the navigation drawer. Do this by calling setupWithNavController()
        NavigationUI.setupWithNavController(binding.navigationView, navController)
    }

    //override the onSupportNavigateUp()
    // method to call navigateUp() in the navigation controller
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}