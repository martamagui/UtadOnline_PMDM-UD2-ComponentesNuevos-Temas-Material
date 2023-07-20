package com.utad.newComponets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToSwitch.setOnClickListener { goToSwitchFragment() }
        binding.btnGoToCheckbox.setOnClickListener { goToCheckBox() }
        binding.btnGoToButtons.setOnClickListener { goToButtonsFragment() }
        binding.btnGoToFab.setOnClickListener { gotToFabFragment() } 
        binding.btnGoToCardView.setOnClickListener { goToCardViewFragment() }
        binding.btnGoToScrolls.setOnClickListener { goToScrollFragment() }
        binding.btnGoToToolbar.setOnClickListener { goToToolbarFragment() }
        binding.btnGoToCoordinator.setOnClickListener { goToCoordinatorFragment() }
        binding.btnGoToBottomNavigation.setOnClickListener { goToBottomNavigationFragment() }
        binding.btnGoToNavDrawer.setOnClickListener { goToNavdrawerFragment() }
    }

    private fun goToNavdrawerFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToNavdrawerFragment()
        findNavController().navigate(action)
    }

    private fun goToBottomNavigationFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToBottomNavigationFragment()
        findNavController().navigate(action)
    }

    private fun goToCoordinatorFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToCoordinatorAndCollapsingToolbarFragment()
        findNavController().navigate(action)
    }

    private fun goToToolbarFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToToolbarFragment()
        findNavController().navigate(action)
    }

    private fun goToScrollFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToScrollsFragment()
        findNavController().navigate(action)
    }

    private fun goToCardViewFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToCardViewFragment()
        findNavController().navigate(action)
    }

    private fun gotToFabFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToFabFragment()
        findNavController().navigate(action)
    }

    private fun goToButtonsFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToButtonsFragment()
        findNavController().navigate(action)
    }

    private fun goToCheckBox() {
        val action = IndexFragmentDirections.actionIndexFragmentToSwitchFragment()
        findNavController().navigate(action)
    }

    private fun goToSwitchFragment() {
        val action = IndexFragmentDirections.actionIndexFragmentToSwitchFragment()
        findNavController().navigate(action)
    }
}