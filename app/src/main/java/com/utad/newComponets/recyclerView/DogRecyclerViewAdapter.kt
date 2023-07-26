package com.utad.newComponets.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utad.newComponets.databinding.ItemDogBinding

class DogRecyclerViewAdapter(
    var dogList: MutableList<Dog>,
    private val onClick: (Dog) -> Unit
) : RecyclerView.Adapter<DogRecyclerViewAdapter.DogViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDogBinding.inflate(inflater, parent, false)
        return DogViewHolder(binding)
    }


    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        //Obtenemos el item de la lita que toca pintar en esta posición
        val dog = dogList[position]

        //Pintamos los datos
        holder.binding.root.setOnClickListener { onClick(dog) }
        holder.binding.ivItemDog.setImageDrawable(dog.image)
        holder.binding.tvItemName.text = dog.name
        holder.binding.tvType.text = dog.type
    }

    fun updateList( dogList: MutableList<Dog>){
        this.dogList = dogList
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    inner class DogViewHolder(val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root)
}