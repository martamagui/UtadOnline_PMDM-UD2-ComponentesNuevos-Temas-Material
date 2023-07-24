package com.utad.newComponets.recyclerView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentRecyclerViewBinding


class RecyclerViewFragment : Fragment() {

    private lateinit var _binding: FragmentRecyclerViewBinding
    private val binding: FragmentRecyclerViewBinding get() = _binding

    private lateinit var adapter: DogRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Asignamos el layout manager a nuestra lista
        binding.rvDogs.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        //Inicializamos el adapter
        val list = getDogList()
        adapter = DogRecyclerViewAdapter(list) { sayMyName(it) }
        binding.rvDogs.adapter = adapter
    }

    private fun sayMyName(dog: Dog) {
        Toast.makeText(requireContext(), dog.name, Toast.LENGTH_SHORT).show()

        val newList = mutableListOf<Dog>()
        newList.addAll(getDogList())
        newList.add(
            Dog(
                "Cookie",
                "Corgi",
                resources.getDrawable(R.drawable.pic_corgi, requireActivity().theme)
            )
        )
        newList.add(
            Dog(
                "Brownie",
                "Corgi",
                resources.getDrawable(R.drawable.pic_corgi, requireActivity().theme)
            )
        )
        //llama a la función que hemos creado para actualiizar los datos
        adapter.updateList(newList)
        //Avisa al adaptador de que hay datos nuevos
        adapter.notifyDataSetChanged()
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
                "Puchoo",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ), Dog(
                "Puchooooo",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ), Dog(
                "Puchi",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ), Dog(
                "Puchtyuty",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ), Dog(
                "Puchtywery",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            ), Dog(
                "Pwer",
                "Beagle",
                resources.getDrawable(R.drawable.pic_beagle, requireActivity().theme)
            )
        )
    }
}