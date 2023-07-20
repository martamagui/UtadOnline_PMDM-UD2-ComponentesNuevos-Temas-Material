package com.utad.newComponets.components.scrollViews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentScrollViewBinding

class ScrollViewFragment : Fragment() {

    private lateinit var _binding: FragmentScrollViewBinding
    private val binding: FragmentScrollViewBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrollViewBinding.inflate(inflater, container, false)
        return binding.root
    }

}