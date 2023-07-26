package com.utad.newComponets.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utad.newComponets.databinding.ItemListDogBinding

class DogListAdapter(
    private val onClickAction: () -> Unit,
    private val onLongClickAction: (Dog) -> Unit
) :
    ListAdapter<Dog, DogListAdapter.DogListAdapterViewHolder>(DogItemCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListDogBinding = ItemListDogBinding.inflate(inflater, parent, false)
        return DogListAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogListAdapterViewHolder, position: Int) {
        val dog: Dog = getItem(position)

        holder.binding.ivDogV2.setImageDrawable(dog.image)
        holder.binding.tvDogNameV2.text = dog.name
        holder.binding.root.setOnClickListener {
            onClickAction()
        }
        holder.binding.root.setOnLongClickListener {
            onLongClickAction(dog)
            return@setOnLongClickListener true
        }
    }

    inner class DogListAdapterViewHolder(val binding: ItemListDogBinding) :
        RecyclerView.ViewHolder(binding.root)
}


object DogItemCallBack : DiffUtil.ItemCallback<Dog>() {
    override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
        return oldItem == newItem
    }

}
