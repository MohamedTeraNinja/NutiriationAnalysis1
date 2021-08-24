package com.mohammedragab.nutiriationanalysis1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mohammedragab.nutiriationanalysis1.databinding.ActivityMainBinding
import com.mohammedragab.nutiriationanalysis1.di.AnalysisComponent

class MainActivity : AppCompatActivity() {
    private   lateinit var  binding: ActivityMainBinding
    lateinit var  analysisComponent: AnalysisComponent
    private lateinit var  navController : NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        analysisComponent=    (application as MyApplication).applicationComponent.homeComponent().create()
        analysisComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        navController = findNavController(R.id.nav_host_fragment_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)


    }
}