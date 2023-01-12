package com.diakonov.testcountry.screens.main

import android.annotation.SuppressLint

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

import com.diakonov.testcountry.databinding.ItemCountryLayoutBinding
import com.diakonov.testcountry.model.InfoItem
import com.squareup.picasso.Picasso


class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var listInfo = emptyList<InfoItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemCountryLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val mainItem : InfoItem = listInfo[position]

        holder.bind(mainItem)

    }

    override fun getItemCount(): Int {
        return listInfo.size

    }



    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<InfoItem>){
        listInfo = list
        notifyDataSetChanged()
    }

    class MainViewHolder(private val binding: ItemCountryLayoutBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(mainItem: InfoItem){

            binding.tvName.text = mainItem.name
            Picasso.get().load(mainItem.flags.png).into(binding.imFlag)

        }
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainInfoFragment.clickItem(listInfo[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)

    }


}