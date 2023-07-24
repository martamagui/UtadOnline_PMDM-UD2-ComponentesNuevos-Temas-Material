package com.utad.newComponets

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.utad.newComponets.components.BottomNavigationActivity
import com.utad.newComponets.components.NavDrawerActivity
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
        binding.btnGoToNavDrawer.setOnClickListener { goToNavdrawer() }
        binding.btnGoToRecyclerView.setOnClickListener { goToRecyclerView() }
    }

    private fun goToRecyclerView() {
        val action = IndexFragmentDirections.actionIndexFragmentToRecyclerViewFragment()
        findNavController().navigate(action)
    }

    private fun goToNavdrawer() {
        val intent = Intent(requireContext(), NavDrawerActivity::class.java)
        startActivity(intent)
    }

    private fun goToBottomNavigationFragment() {
        val intent = Intent(requireContext(), BottomNavigationActivity::class.java)
        startActivity(intent)
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