package com.utad.newComponets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.databinding.FragmentIndexBinding


class IndexFragment : Fragment() {

    private lateinit var _binding: FragmentIndexBinding
    private val binding: FragmentIndexBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIndexBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}