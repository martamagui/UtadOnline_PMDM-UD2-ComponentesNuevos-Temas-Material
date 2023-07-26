package com.utad.newComponets.recyclerView

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.utad.newComponets.R
import com.utad.newComponets.databinding.FragmentRecyclerViewWithListAdapterBinding


class RecyclerViewWithListAdapterFragment : Fragment() {

    private lateinit var _bindinding: FragmentRecyclerViewWithListAdapterBinding
    private val binding: FragmentRecyclerViewWithListAdapterBinding get() = _bindinding

    private var dogList: MutableList<Dog> = mutableListOf()

    private lateinit var adapter: DogListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindinding =
            FragmentRecyclerViewWithListAdapterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dogList.addAll(getDogList())

        //binding.rvDogList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvDogList.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = DogListAdapter({ sayType() }) { deleteDog(it) }

        binding.rvDogList.adapter = adapter
        adapter.submitList(dogList)

        binding.btnAdd.setOnClickListener { addNewDog() }

    }

    private fun deleteDog(dog: Dog) {
        val newList: MutableList<Dog> = mutableListOf()
        newList.addAll(adapter.currentList)
        newList.remove(dog)
        //Llama sólo a que se actualice la lista
        adapter.submitList(newList)
    }

    private fun sayType() {
        Snackbar.make(binding.root, "Me has hecho click!!👋", Snackbar.LENGTH_SHORT).show()
    }

    private fun addNewDog() {
        if (binding.etDog.text != null && binding.etDog.text.isNotEmpty()) {
            val newDogName = binding.etDog.text.toString().trim()
            val newDog = Dog(
                newDogName,
                "Nuevo",
                resources.getDrawable(R.drawable.pic_corgi, requireActivity().theme)
            )
            dogList = adapter.currentList
            dogList.add(newDog)

            //Actualizar los elementos de la lista
            if (adapter != null) {
                adapter.submitList(dogList)
            }
        } else {
            Snackbar.make(binding.root, "El perrito necesita un nombre", Snackbar.LENGTH_SHORT)
                .show()
        }
        hideKeyBoard()
        binding.etDog.setText("")
    }

    private fun hideKeyBoard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity?.currentFocus?.windowToken
        imm.hideSoftInputFromWindow(view, 0)
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
            )
        )
    }
}