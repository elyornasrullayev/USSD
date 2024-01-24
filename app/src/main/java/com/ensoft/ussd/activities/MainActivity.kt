package com.ensoft.ussd.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ensoft.ussd.R
import com.ensoft.ussd.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private lateinit var listener: NavController.OnDestinationChangedListener

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationView()

        shapeAppearanceModel()

        binding.fab.setOnClickListener {
            onBackPressed()

        }
        bottomNavigationClickListener()

    }

    private fun initNavigationView() {
        navController = findNavController(R.id.nav_host_fragment)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        navigationView.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) ||super.onSupportNavigateUp()
    }

    private fun shapeAppearanceModel() {

        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
        binding.bottomNavigationView.setBackgroundColor(Color.parseColor("#228BD6"))
        binding.bottomNavigationView.background = null
    }

    private fun bottomNavigationClickListener(){
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
                item ->
            when(item.itemId){
                R.id.balance ->
                    Toast.makeText(
                        applicationContext,
                        "balance is clicked",
                        Toast.LENGTH_SHORT
                    ).show()

                R.id.operator -> Toast.makeText(
                    applicationContext,
                    "operator is clicked",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.news -> Toast.makeText(
                    applicationContext,
                    "news is clicked",
                    Toast.LENGTH_SHORT
                )
                    .show()

                R.id.settings -> Toast.makeText(
                    applicationContext,
                    "settings is clicked",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

}