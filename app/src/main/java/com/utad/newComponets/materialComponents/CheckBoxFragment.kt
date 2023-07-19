package com.utad.newComponets.materialComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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


}