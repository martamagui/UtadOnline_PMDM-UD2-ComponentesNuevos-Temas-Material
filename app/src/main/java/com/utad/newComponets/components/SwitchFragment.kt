package com.utad.newComponets.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentSwitchBinding


class SwitchFragment : Fragment() {

    private lateinit var _binding: FragmentSwitchBinding
    private val binding: FragmentSwitchBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSwitchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Cambiar el estado de tu swich:
        binding.swCheckedMaterial2.isChecked = true // Estado-> Checked
        binding.swCheckedMaterial2.isChecked = false // Estado-> UNChecked

        binding.swChecked.setOnCheckedChangeListener { buttonView, isChecked ->
            showSwitchStatus(isChecked)
        }
        binding.swUnchecked.setOnCheckedChangeListener { buttonView, isChecked ->
            showSwitchStatus(isChecked)
        }
        binding.swCheckedMaterial2.setOnCheckedChangeListener { buttonView, isChecked ->
            showSwitchStatus(isChecked)
        }

    }

    private fun showSwitchStatus(isChecked: Boolean) {
        if (isChecked) {
            Snackbar.make(binding.root, R.string.switch_message_1, Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, R.string.switch_message_2, Snackbar.LENGTH_SHORT).show()
        }
    }

}