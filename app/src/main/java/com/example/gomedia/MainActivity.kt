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

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {
                selectedFrag(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_search -> {
                selectedFrag(SearchFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_add -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_heart -> {
                selectedFrag(NotificationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_profile_icon -> {
                selectedFrag(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
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

        selectedFrag(HomeFragment())

    }

    private fun selectedFrag (fragment: Fragment){

        val selected = supportFragmentManager.beginTransaction()
        selected.replace(R.id.fragment_container_view_tag, fragment)
        selected.commit()
    }
}