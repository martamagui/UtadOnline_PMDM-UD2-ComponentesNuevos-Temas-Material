package com.utad.newComponets.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentRecyclerViewBinding


class RecyclerViewFragment : Fragment() {

    private lateinit var _binding: FragmentRecyclerViewBinding
    private val binding: FragmentRecyclerViewBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    private fun getDogList(): List<Dog> {
        return listOf(
            Dog(
                "Pipo",
                "Corgi",
                resources.getDrawable(R.drawable.pic_corgi, requireActivity().theme)
            ),
            Dog(
                "Rex",
                "P. Alemán",
                resources.getDrawable(R.drawable.pic_pastor_aleman, requireActivity().theme)
            ),
            Dog(
                "Chancho",
                "Carlino",
                resources.getDrawable(R.drawable.pic_carlino, requireActivity().theme)
            ),
            Dog(
                "Pucho",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ),
        )
    }
}