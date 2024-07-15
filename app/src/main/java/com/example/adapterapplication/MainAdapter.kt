package com.example.adapterapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapterapplication.databinding.ItemFiveBinding
import com.example.adapterapplication.databinding.ItemFourBinding
import com.example.adapterapplication.databinding.ItemOneBinding
import com.example.adapterapplication.databinding.ItemThreeBinding
import com.example.adapterapplication.databinding.ItemTwoBinding

class MainAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val ITEM_TYPE_ONE = 1
        const val ITEM_TYPE_TWO = 2
        const val ITEM_TYPE_THREE = 3
        const val ITEM_TYPE_FOUR = 4
        const val ITEM_TYPE_FIVE = 5
    }

    private val itemList = mutableListOf<Int>(1, 2, 3, 4, 5,2,2,4,4,5,5,7,8)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> OneViewHolder(
                ItemOneBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            2 -> TwoViewHolder(
                ItemTwoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            3 -> ThreeViewHolder(
                ItemThreeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            4 -> FourViewHolder(
                ItemFourBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            5 -> FiveViewHolder(
                ItemFiveBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> {
                OneViewHolder(
                    ItemOneBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = itemList[position]) {
            1 -> {
                holder as OneViewHolder
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        "${holder.binding.textView.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            2 -> {
                holder as TwoViewHolder
                val subAdapter = SubAdapter(listener = object : OnClickListener{
                    override fun onClick(text:String) {
                        Toast.makeText(holder.itemView.context,text,Toast.LENGTH_SHORT).show()
                    }

                })
                holder.binding.recyclerView.apply {
                    adapter = subAdapter
                    layoutManager = LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false)
                }

                subAdapter.setData(mutableListOf<String>("Dog", "Cat", "Ant", "Bird", "Cow", "Tiger", "Lion"))

            }

            3 -> {
                holder as ThreeViewHolder
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        "${holder.binding.textView.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            4 -> {
                holder as FourViewHolder
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        "${holder.binding.textView.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            5 -> {
                holder as FiveViewHolder
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        "${holder.binding.textView.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            else -> {
                holder as OneViewHolder
                holder.itemView.setOnClickListener {
                    Toast.makeText(
                        holder.itemView.context,
                        "${holder.binding.textView.text}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            1 -> ITEM_TYPE_ONE

            2 -> ITEM_TYPE_TWO

            3 -> ITEM_TYPE_THREE

            4 -> ITEM_TYPE_FOUR

            5 -> ITEM_TYPE_FIVE

            else -> ITEM_TYPE_ONE
        }
    }


    class OneViewHolder(var binding: ItemOneBinding) : RecyclerView.ViewHolder(binding.root)
    class TwoViewHolder(var binding: ItemTwoBinding) : RecyclerView.ViewHolder(binding.root)
    class ThreeViewHolder(var binding: ItemThreeBinding) : RecyclerView.ViewHolder(binding.root)
    class FourViewHolder(var binding: ItemFourBinding) : RecyclerView.ViewHolder(binding.root)
    class FiveViewHolder(var binding: ItemFiveBinding) : RecyclerView.ViewHolder(binding.root)
}