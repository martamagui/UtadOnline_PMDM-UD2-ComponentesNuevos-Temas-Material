package com.utad.newComponets.materialComponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.databinding.FragmentNavdrawerBinding


class NavdrawerFragment : Fragment() {
    private lateinit var _binding: FragmentNavdrawerBinding
    private val binding: FragmentNavdrawerBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavdrawerBinding.inflate(inflater, container, false)
        return binding.root
    }
}