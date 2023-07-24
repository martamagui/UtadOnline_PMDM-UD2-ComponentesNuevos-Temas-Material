package com.utad.newComponets.components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.utad.newComponets.R
import com.utad.newComponets.databinding.ActivityNavDrawerBinding

class NavDrawerActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityNavDrawerBinding
    private val binding: ActivityNavDrawerBinding get() = _binding

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout: DrawerLayout = binding.dlContent
        val navViewDrawer: NavigationView = binding.nvDrawer


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navViewDrawer.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.firstOptionFragment -> {
                    Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.secondOptionFragment -> {
                    Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }

                R.id.thirdOptionFragment -> {
                    Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
                    drawerLayout.close()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toggle.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

}