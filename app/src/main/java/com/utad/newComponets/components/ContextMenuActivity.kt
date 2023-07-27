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

        //Ponemos en observación la vista en la que queremos que aparezca el ContextMenu
        registerForContextMenu(binding.cvDogMenu)

        binding.btnShow.setOnClickListener {
            showCard()
        }
    }

    //Para asignar nuestro menu al contextMenú cuando se cree
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //obtenemos el layoutinflater del menu
        val menuInflater = menuInflater
        //hacemos que el inflater cargue nuestro menu
        menuInflater.inflate(R.menu.menu_example_context_menu, menu)
    }

    //Nos permite controlar el item que ha sido pulsado
    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.hide) {
            hideCard()
        } else if (item.itemId == R.id.change_color) {
            changeCardBgColor()
        }

        return super.onContextItemSelected(item)
    }

    private fun hideCard() {
        binding.cvDogMenu.visibility = View.GONE
        binding.btnShow.visibility = View.VISIBLE
    }

    private fun showCard() {
        binding.cvDogMenu.visibility = View.VISIBLE
        binding.btnShow.visibility = View.GONE
    }

    private fun changeCardBgColor() {
        val colors = listOf(
            R.color.green,
            R.color.gray,
            R.color.md_theme_dark_onPrimary,
            R.color.md_theme_dark_onSurface,
            R.color.md_theme_dark_surfaceTint,
            R.color.md_theme_dark_tertiaryContainer,
            R.color.CustomColor1
        )
        binding.cvDogMenu.setCardBackgroundColor(getColor(colors.random()))
    }
}