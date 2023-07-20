package com.utad.newComponets.components.scrollViews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.databinding.FragmentHorizontalScrollBinding


class HorizontalScrollFragment : Fragment() {


    private lateinit var _binding: FragmentHorizontalScrollBinding
    private val binding: FragmentHorizontalScrollBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHorizontalScrollBinding.inflate(inflater, container, false)
        return binding.root
    }


}