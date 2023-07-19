package com.utad.newComponets.materialComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.databinding.FragmentToolbarBinding


class ToolbarFragment : Fragment() {
    private lateinit var _binding: FragmentToolbarBinding
    private val binding: FragmentToolbarBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentToolbarBinding.inflate(inflater, container, false)
        return binding.root
    }
}