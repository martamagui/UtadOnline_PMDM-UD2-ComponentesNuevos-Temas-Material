package com.utad.newComponets.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentCheckBoxBinding


class CheckBoxFragment : Fragment() {

    private lateinit var _binding: FragmentCheckBoxBinding
    private val binding: FragmentCheckBoxBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentCheckBoxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Cambiar el estado a checked
        binding.cbTermsAndConditions1.isChecked = true
        // Cambiar el estado a UNchecked
        binding.cbTermsAndConditions1.isChecked = false

        // Escuchar los cambios de estado del checkbox
        binding.cbTermsAndConditions1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Snackbar.make(binding.root, R.string.switch_message_1, Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, R.string.switch_message_2, Snackbar.LENGTH_SHORT).show()
            }
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