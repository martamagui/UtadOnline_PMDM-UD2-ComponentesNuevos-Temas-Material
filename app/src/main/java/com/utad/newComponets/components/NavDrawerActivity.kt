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

        //Es necesario poner esto aunque no tengasmos Toolbar, si no no funciona
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Detectamos el click de los elementos del menú con "setNavigationItemSelectedListener"
        navViewDrawer.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.firstOptionFragment -> showItemClicked(item, drawerLayout)
                R.id.secondOptionFragment -> showItemClicked(item, drawerLayout)
                R.id.thirdOptionFragment -> showItemClicked(item, drawerLayout)
            }
            return@setNavigationItemSelectedListener true
        }
    }

    //Para que la toolbar detecte que hemos pulsado el navigationIcon
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toggle.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    private fun showItemClicked(
        item: MenuItem,
        drawerLayout: DrawerLayout
    ) {
        Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
        drawerLayout.close()
    }
}