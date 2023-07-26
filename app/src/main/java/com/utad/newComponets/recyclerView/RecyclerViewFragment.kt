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
        adapter = DogRecyclerViewAdapter(list) {
            sayMyName(it)
            //addMoreItems()
            //removeItem(it)
            insertItem()
        }
        binding.rvDogs.adapter = adapter


    }

    private fun infoRecyclerView() {
        //Métodos para avisar de cambios en las listas de la RecyclerView
        //Avisa de que hemos borrado el elemento de la posición indicada
        adapter.notifyItemRemoved(0)
        //Avisa que hemos añadido un elemento en la posición indicada
        adapter.notifyItemInserted(0)
        //Avisa de que hemos cambiado alguna propiedad del elemento y necesita ser re-pintado
        adapter.notifyItemChanged(0)
        //Avisa de que un elemento cambió de posición
        adapter.notifyItemMoved(0, 1)
        //Avisa de que hay un nuevo set de datos
        adapter.notifyDataSetChanged()
    }

    private fun removeItem(dog: Dog) {
        val postion = adapter.dogList.indexOf(dog)
        adapter.dogList.remove(dog)
        adapter.notifyItemRemoved(postion)
    }

    private fun sayMyName(dog: Dog) {
        Toast.makeText(requireContext(), dog.name, Toast.LENGTH_SHORT).show()
    }

    private fun addMoreItems() {
        val newList = mutableListOf<Dog>()
        newList.addAll(adapter.dogList)
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

    private fun insertItem() {
        adapter.dogList.add(
            2, Dog(
                "Danerys",
                "Corgi",
                resources.getDrawable(R.drawable.pic_corgi, requireActivity().theme)
            )
        )
        adapter.notifyItemInserted(2)
    }

    private fun getDogList(): MutableList<Dog> {
        return mutableListOf(
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