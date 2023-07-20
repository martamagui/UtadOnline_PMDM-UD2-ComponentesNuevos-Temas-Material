package com.utad.newComponets.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.utad.newComponets.R
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setOnMenuItemClickListener { item->
            when(item.itemId){
                R.id.save->{
                    Snackbar.make(binding.root, "Save", Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.more->{
                    Snackbar.make(binding.root, "More", Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding.toolbar.setNavigationOnClickListener {
            //Vuelve hacia atrás
            findNavController().popBackStack()
        }
    }
}