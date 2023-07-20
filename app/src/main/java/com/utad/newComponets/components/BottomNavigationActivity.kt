package com.utad.newComponets.components

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.utad.newComponets.R
import com.utad.newComponets.databinding.ActivityBottomNavigationBinding

class BottomNavigationActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityBottomNavigationBinding
    private val binding: ActivityBottomNavigationBinding get()=_binding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        _binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val navController = findNavController()


    }

}