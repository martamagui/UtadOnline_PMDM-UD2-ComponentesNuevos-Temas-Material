package com.utad.newComponets.materialComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.databinding.FragmentScrollsBinding


class ScrollsFragment : Fragment() {
    private lateinit var _binding: FragmentScrollsBinding
    private val binding: FragmentScrollsBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrollsBinding.inflate(inflater, container, false)
        return binding.root
    }
}