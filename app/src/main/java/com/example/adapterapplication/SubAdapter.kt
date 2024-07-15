package com.example.adapterapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterapplication.databinding.ItemSubBinding

class SubAdapter(private val listener: OnClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SubViewHolder(
            ItemSubBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as SubViewHolder
        holder.binding.textView.text = itemList[position]
        holder.itemView.setOnClickListener {
            listener.onClick(holder.binding.textView.text.toString())
        }
        holder.binding.cardView.setCardBackgroundColor(ImageUtils.getRandomColor())
    }

    fun setData(data: MutableList<String>) {
        this.itemList = data
    }

    class SubViewHolder(var binding: ItemSubBinding) : RecyclerView.ViewHolder(binding.root)
}

interface OnClickListener {
    fun onClick(text: String)
}