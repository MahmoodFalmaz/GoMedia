package com.example.gomedia

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gomedia.Fragments.HomeFragment
import com.example.gomedia.Fragments.NotificationFragment
import com.example.gomedia.Fragments.ProfileFragment
import com.example.gomedia.Fragments.SearchFragment
import com.example.gomedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    internal var selectedFrag: Fragment? = null
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                selectedFrag = HomeFragment()
            }
            R.id.nav_search -> {
                selectedFrag = SearchFragment()
            }
            R.id.nav_add -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_heart -> {
                selectedFrag = NotificationFragment()
            }
            R.id.nav_profile_icon -> {
                selectedFrag = ProfileFragment()
            }
        }

        if (selectedFrag != null){
            supportFragmentManager.beginTransaction().replace(
                androidx.fragment.R.id.fragment_container_view_tag, selectedFrag!!
            ).commit()
        }
        false
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().replace(
            androidx.fragment.R.id.fragment_container_view_tag,
            HomeFragment()
        ).commit()

    }
}