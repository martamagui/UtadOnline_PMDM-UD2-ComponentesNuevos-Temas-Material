package com.utad.newComponets.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScrollView.setOnClickListener { goToScroll() }
        binding.btnHorizontalScrollView.setOnClickListener { goToHorizontalScroll() }
        binding.btnNestedScrollView.setOnClickListener { goToNestedScroll() }
    }

    private fun goToNestedScroll() {
        val action =  ScrollsFragmentDirections.actionScrollsFragmentToNestedScrollViewFragment()
        findNavController().navigate(action)
    }

    private fun goToHorizontalScroll() {
        val action =  ScrollsFragmentDirections.actionScrollsFragmentToHorizontalScrollFragment()
        findNavController().navigate(action)
    }

    private fun goToScroll() {
        val action =  ScrollsFragmentDirections.actionScrollsFragmentToScrollViewFragment()
        findNavController().navigate(action)
    }
}