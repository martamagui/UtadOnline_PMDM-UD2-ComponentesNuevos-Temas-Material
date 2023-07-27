package com.utad.newComponets.components

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import com.utad.newComponets.R
import com.utad.newComponets.databinding.ActivityContextMenuBinding

class ContextMenuActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityContextMenuBinding
    private val binding: ActivityContextMenuBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityContextMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.cvContextMenu)

        binding.btnShow.setOnClickListener {
            binding.cvContextMenu.visibility = View.VISIBLE
            binding.btnShow.visibility = View.GONE
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_example_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.hide) {
            binding.cvContextMenu.visibility = View.GONE
            binding.btnShow.visibility = View.VISIBLE
        } else if (item.itemId == R.id.change_color) {
            val colors = listOf(
                R.color.green,
                R.color.gray,
                R.color.md_theme_dark_onPrimary,
                R.color.md_theme_dark_onSurface,
                R.color.md_theme_dark_surfaceTint,
                R.color.md_theme_dark_tertiaryContainer,
                R.color.CustomColor1
            )
            binding.cvContextMenu.setCardBackgroundColor(getColor(colors.random()))
        }
        return super.onContextItemSelected(item)
    }
}